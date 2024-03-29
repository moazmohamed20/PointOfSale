CREATE VIEW SAFE_VIEW
AS
    SELECT DATE, STATEMENT, EMPLOYEE, PRICE
    FROM SAFE
    ORDER BY DATE;

CREATE VIEW EXPENSES_VIEW
AS
    SELECT DATE, EXPENSE, COST
    FROM EXPENSES
    JOIN SAFE ON SAFEID = SAFE.ID
    ORDER BY DATE;

CREATE VIEW PURCHASE_INVOICES_VIEW
AS
    SELECT "NO", DATE, NAME AS SUPPLIER, TOTAL
    FROM PURCHASEINVOICE
    JOIN SAFE ON SAFEID = SAFE.ID
    LEFT JOIN SUPPLIERS ON SUPPLIERID = SUPPLIERS.ID
    ORDER BY "NO";

CREATE VIEW PURCHASES_VIEW
AS
    SELECT DATE, NAME AS PRODUCT, PI_P.COST, PI_P.QUANTITY, PI_P.COST * PI_P.QUANTITY AS TOTAL
    FROM PURCHASEINVOICE_PRODUCT AS PI_P
    JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE
    JOIN PURCHASEINVOICE ON INVOICENO = PURCHASEINVOICE."NO"
    JOIN SAFE ON SAFEID = SAFE.ID
    ORDER BY INVOICENO;

CREATE VIEW SALE_INVOICES_VIEW
AS
    SELECT "NO", DATE, NAME AS CUSTOMER, TOTAL
    FROM SALEINVOICE
    JOIN SAFE ON SAFEID = SAFE.ID
    LEFT JOIN CUSTOMERS ON CUSTOMERID = CUSTOMERS.ID
    ORDER BY "NO";

CREATE VIEW SALES_VIEW
AS
    SELECT DATE, NAME AS PRODUCT, SI_P.PRICE, SI_P.QUANTITY, SI_P.DISCOUNT, (SI_P.PRICE * SI_P.QUANTITY - SI_P.DISCOUNT) AS TOTAL
    FROM SALEINVOICE_PRODUCT AS SI_P
    JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE
    JOIN SALEINVOICE ON INVOICENO = SALEINVOICE."NO"
    JOIN SAFE ON SAFEID = SAFE.ID
    ORDER BY INVOICENO;

CREATE VIEW RETURN_INVOICES_VIEW
AS
    SELECT RI."NO", DATE, NAME AS CUSTOMER, RI.TOTAL
    FROM RETURNINVOICE AS RI
    JOIN SAFE ON SAFEID = SAFE.ID
    JOIN SALEINVOICE ON SALEINVOICENO = SALEINVOICE."NO"
    LEFT JOIN CUSTOMERS ON CUSTOMERID = CUSTOMERS.ID
    ORDER BY RI."NO";

CREATE VIEW RETURNS_VIEW
AS
    SELECT DATE, NAME AS PRODUCT, SI_P.PRICE, RI_P.QUANTITY, SI_P.DISCOUNT, (SI_P.PRICE * RI_P.QUANTITY - SI_P.DISCOUNT) AS TOTAL
    FROM RETURNINVOICE_PRODUCT AS RI_P
    JOIN PRODUCTS ON PRODUCTCODE = PRODUCTS.CODE
    JOIN RETURNINVOICE ON INVOICENO = RETURNINVOICE."NO"
    JOIN SAFE ON SAFEID = SAFE.ID
    JOIN SALEINVOICE_PRODUCT AS SI_P ON (SALEINVOICENO = SI_P.INVOICENO AND RI_P.PRODUCTCODE = SI_P.PRODUCTCODE)
    ORDER BY RI_P.INVOICENO;