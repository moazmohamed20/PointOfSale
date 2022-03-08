package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DBManager {

    // DB DATA
    
    private String connectionURL = "jdbc:derby://localhost:1527/DB";
    private Connection connection;
    private Statement statement;

    // QUERY STATISTICS
    private String exception;
    private ResultSet resultSet;
    public TableModel resultTable;
    public int recordsCount;

    // SINGELTON DESIGN PATTERN
    private static final DBManager INSTANCE = new DBManager();

    // CONSTRUCTOR PRIVATE SO THAT THIS CLASS CANNOT BE INSTANTIATED
    private DBManager() {
        try {
            connection = DriverManager.getConnection(connectionURL, "APP", "APP");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database: " + e.getMessage(), "Point Of Sale", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static DBManager getInstance() {
        // RETURN THE ONLY OBJECT AVAILABLE
        return INSTANCE;
    }

    // RESET OLD STATISTICS
    private void resetStatistics() {
        exception = "";
        resultSet = null;
        resultTable = null;
        recordsCount = 0;
    }

    // EXECUTE QUERY
    public int executeQuery(String query) {
        // RESET QUERY STATS
        resetStatistics();

        try {
            // CREATE DB STATEMENT
            statement = connection.createStatement();

            // EXECUTE STATEMENT
            boolean hasResultSet = statement.execute(query, Statement.RETURN_GENERATED_KEYS);

            // FILL RESULTSET
            if (hasResultSet) {
                resultSet = statement.getResultSet();
                resultTable = resultSetToTable(resultSet);
                recordsCount = resultTable.getRowCount();

                // RETURN GENERATED KEY
            } else if (statement.getGeneratedKeys() != null && statement.getGeneratedKeys().next()) {
                return statement.getGeneratedKeys().getInt(1);
            }
        } catch (SQLException e) {
            // CAPTURE ERROR
            exception = e.getMessage();
        }

        return 0;
    }

    // FILL TABLE
    public void fillTable(JTable table, int... hiddenColumns) {
        table.setModel(resultTable);

        // HIDE COLUMNS
        for (int i = 0; i < hiddenColumns.length; i++) {
            table.removeColumn(table.getColumnModel().getColumn(hiddenColumns[i] - i));
        }
    }

    // EXECUTE OPERATION: SUM(), AVG(), COUNT(), ...
    public double executeOperation(String query) {
        // RESET QUERY STATS
        resetStatistics();

        try {
            // CREATE DB STATEMENT
            statement = connection.createStatement();

            // EXECUTE STATEMENT & FILL RESULTSET
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                return resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            // CAPTURE ERROR
            exception = e.getMessage();
        }

        return 0;
    }

    // ERROR CHECKING
    public boolean hasException(boolean showMessage) {
        if (exception.isEmpty()) {
            return false;
        }
        if (showMessage) {
            JOptionPane.showMessageDialog(null, exception, "SQL Exception", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }

    private TableModel resultSetToTable(ResultSet set) {
        try {
            ResultSetMetaData metaData = set.getMetaData();

            // Get Columns Names
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();
            for (int column = 1; column <= numberOfColumns; column++) {
                String columnName = metaData.getColumnLabel(column).toUpperCase();
                if (columnName.length() > 3) {
                    columnName = columnName.substring(0, 1).toUpperCase() + columnName.substring(1).toLowerCase();
                }
                columnNames.addElement(columnName);
            }

            // Get All Rows
            Vector rows = new Vector();
            while (set.next()) {
                Vector newRow = new Vector();
                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(set.getObject(i));
                }
                rows.addElement(newRow);
            }
            return new DefaultTableModel(rows, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

        } catch (SQLException e) {
            // CAPTURE ERROR
            exception = e.getMessage();
            return null;
        }
    }

}
