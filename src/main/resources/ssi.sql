USE ssi;

PRINT 'Start';
GO

/*procedure to create incident_type*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[create_incident_type]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[create_incident_type];
END
GO
CREATE PROCEDURE [dbo].[create_incident_type]
(
    @name VARCHAR(50),
    @description VARCHAR(100),
    @incident_type_id INT OUTPUT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    INSERT INTO [dbo].[incident_type](name, description)
    VALUES(@name, @description);
    SELECT @incident_type_id = @@IDENTITY;
    PRINT @incident_type_id;
END
GO

PRINT 'Procedure create_incident_type was created successfully'
GO


/*procedure to update incident_type*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[update_incident_type]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[update_incident_type];
END
GO
CREATE PROCEDURE [dbo].[update_incident_type]
(
	@id INT,
    @name VARCHAR(50),
    @description VARCHAR(100),
	@is_deleted BIT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[incident_type] 
	SET name = @name,
	description = @description,
	is_deleted = @is_deleted
	WHERE id = @id;
END
GO

PRINT 'Procedure update_incident_type was created successfully'
GO


/*procedure to delete incident_type*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[delete_incident_type]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[delete_incident_type];
END
GO
CREATE PROCEDURE [dbo].[delete_incident_type]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[incident_type] 
	SET is_deleted = 1
	WHERE id = @id;
END
GO

PRINT 'Procedure delete_incident_type was created successfully'
GO

/*procedure to get incident_type*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_incident_type]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_incident_type];
END
GO
CREATE PROCEDURE [dbo].[get_incident_type]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[incident_type]
	WHERE id = @id;
END
GO

PRINT 'Procedure get_incident_type was created successfully'
GO


/*procedure to get all incident_type*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_incident_type]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_incident_type];
END
GO
CREATE PROCEDURE [dbo].[get_all_incident_type]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[incident_type]
END
GO

PRINT 'Procedure get_all_incident_type was created successfully'
GO
