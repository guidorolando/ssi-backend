USE ssi;

PRINT 'Start';
GO

/*procedure to create accident_agent*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[create_accident_agent]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[create_accident_agent];
END
GO
CREATE PROCEDURE [dbo].[create_accident_agent]
(
    @agent_name VARCHAR(50),
    @accident_agent_id INT OUTPUT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    INSERT INTO [dbo].[accident_agent](agent_name)
    VALUES(@agent_name);
    SELECT @accident_agent_id = @@IDENTITY;
    PRINT @accident_agent_id;
END
GO

PRINT 'Procedure create_accident_agent was created successfully'
GO


/*procedure to update accident_agent*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[update_accident_agent]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[update_accident_agent];
END
GO


CREATE PROCEDURE [dbo].[update_accident_agent]
(
	@id INT,
    @agent_name VARCHAR(50),
 	@is_deleted BIT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[accident_agent] 
	SET agent_name = @agent_name,
	is_deleted = @is_deleted
	WHERE id = @id;
END
GO

PRINT 'Procedure update_accident_agent was created successfully'
GO


/*procedure to delete accident_agent*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[delete_accident_agent]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[delete_accident_agent];
END
GO
CREATE PROCEDURE [dbo].[delete_accident_agent]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[accident_agent] 
	SET is_deleted = 1
	WHERE id = @id;
END
GO

PRINT 'Procedure delete_accident_agent was created successfully'
GO


/*procedure to get incident_type*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_accident_agent]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_accident_agent];
END
GO
CREATE PROCEDURE [dbo].[get_accident_agent]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[accident_agent]
	WHERE id = @id;
END
GO

PRINT 'Procedure get_accident_agent was created successfully'
GO


/*procedure to get all accident_agent*/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_accident_agent]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_accident_agent];
END
GO


CREATE PROCEDURE [dbo].[get_all_accident_agent]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[accident_agent]
END
GO

PRINT 'Procedure get_all_accident_agent was created successfully'
GO