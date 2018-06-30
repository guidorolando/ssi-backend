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


/*procedure to create incident_tag*/
IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[create_incident_tag]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[create_incident_tag];
END
GO
CREATE PROCEDURE [dbo].[create_incident_tag]
(
    @name VARCHAR(50),
    @incident_tag_id INT OUTPUT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    INSERT INTO [dbo].[incident_tag](name)
    VALUES(@name);
    SELECT @incident_tag_id = @@IDENTITY;
    PRINT @incident_tag_id;
END
GO

PRINT 'Procedure create_incident_tag was created successfully'
GO


/*procedure to update incident_tag*/
IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[update_incident_tag]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[update_incident_tag];
END
GO
CREATE PROCEDURE [dbo].[update_incident_tag]
(
	@id INT,
  @name VARCHAR(50)
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[incident_tag]
	  SET name = @name
	  WHERE id = @id;
END
GO

PRINT 'Procedure update_incident_tag was created successfully'
GO

/*procedure to get incident_tag*/
IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[get_incident_tag]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_incident_tag];
END
GO
CREATE PROCEDURE [dbo].[get_incident_tag]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[incident_tag]
	WHERE id = @id;
END
GO

PRINT 'Procedure get_incident_tag was returned'
GO


/*procedure to get all incident_type*/
IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_incident_tag]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_incident_tag];
END
GO
CREATE PROCEDURE [dbo].[get_all_incident_tag]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[incident_tag]
END
GO

PRINT 'Procedure get_all_incident_tag was returned'
GO


/*procedure to create incident_incident_tag*/
IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[create_incident_incident_tag]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[create_incident_incident_tag];
END
GO
CREATE PROCEDURE [dbo].[create_incident_incident_tag]
(
    @incident_id int,
    @incident_tag_id int
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    DECLARE @incidentId int, @incidentTagId int
    SELECT @incidentid = id FROM incident WHERE id=@incident_id
    SELECT @incidentTagId = id FROM incident_tag WHERE id=@incident_tag_id
    IF(@incidentId is not null AND @incidentTagId is not null)
    BEGIN
      INSERT INTO [dbo].[incident_incident_tag](incident_id, incident_tags_id)
      VALUES(@incidentid, @incidentTagId);
    END
END
GO

PRINT 'Procedure create_incident_incident_tag was created successfully'
GO


/******************************************************************************
**  ****  Created
*******************************************************************************
** Procedure : Insert data on Table role  
** Uso de la Base de Datos Creada
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[creat_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[creat_role];
END
GO
CREATE PROCEDURE [dbo].[creat_role]
(
	@role_id INT OUTPUT,
	@name VARCHAR(50),
    @description VARCHAR(150)
    
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    INSERT INTO [dbo].[role] (role_name, Description)
    VALUES(@name, @description);
    SELECT @role_id = @@IDENTITY;
    PRINT @role_id;
END
GO

PRINT 'Procedure insert on table created successfully'
GO

/*******************************************************************************
** Procedure : Update data on Table role  
** Uso de la Base de Datos Creada
******************************************************************************/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[update_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[update_role];
END
GO
CREATE PROCEDURE [dbo].[update_role]
(
	@id INT ,
	@name VARCHAR(50),
    @description VARCHAR(150),
	@is_deleted BIT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[role] 
	SET role_name = @name,
	description = @description
	WHERE id = @id;
END
GO

PRINT 'Procedure update_role created successfully'
GO

/*******************************************************************************
** Procedure : Delete data on Table role  
** 
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[delete_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[delete_role];
END
GO
CREATE PROCEDURE [dbo].[delete_role]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    DELETE FROM [dbo].[role] 
	
	WHERE id = @id;
END
GO

PRINT 'Procedure delete_role created successfully'
GO

/*******************************************************************************
** Procedure : Get data on Table role , for ID
** 
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_role];
END
GO
CREATE PROCEDURE [dbo].[get_role]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[role]
	WHERE id = @id;
END
GO

PRINT 'Procedure get_role was created successfully'
GO


/*******************************************************************************
** Procedure : Get all data on Table role , 
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_role];
END
GO
CREATE PROCEDURE [dbo].[get_all_role]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[role]
END
GO

PRINT 'Procedure get_all_role'
GO

/*******************************************************************************
Procedure : Insert data on Table user_role  
** Uso de la Base de Datos Creada
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[creat_user_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[creat_user_role];
END
GO
CREATE PROCEDURE [dbo].[creat_user_role]
(
	@r_id INT OUTPUT,
	@u_id int
       
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    INSERT INTO [dbo].[user_role] (role_id,user_id)
    VALUES(@r_id, @u_id);
    SELECT @r_id = @@IDENTITY;
    PRINT @r_id;
END
GO

PRINT 'Procedure insert on table created successfully'
GO

/*******************************************************************************
** Procedure : Update data on Table user_role  
** Uso de la Base de Datos Creada
******************************************************************************/
IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[update_user_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[update_user_role];
END
GO
CREATE PROCEDURE [dbo].[update_user_role]
(
	@r_id INT ,
	@u_id INT,
	@is_deleted BIT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    UPDATE [dbo].[user_role] 
	SET role_id = @r_id,
	user_id = @u_id

	WHERE user_id = @u_id;
END
GO

PRINT 'Procedure update_user_role created successfully'
GO

/*******************************************************************************
** Procedure : Delete data on Table user_role  
** 
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[delete_user_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[delete_user_role];
END
GO
CREATE PROCEDURE [dbo].[delete_user_role]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    DELETE FROM [dbo].[user_role] 
	WHERE user_id = @id;
END
GO

PRINT 'Procedure delete_role created successfully'
GO

/*******************************************************************************
** Procedure : Get data on Table role , for ID user
** 
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_user_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_user_role];
END
GO
CREATE PROCEDURE [dbo].[get_user_role]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[user_role]
	WHERE user_id = @id;
END
GO

PRINT 'Procedure get_role was created successfully'
GO


/*******************************************************************************
** Procedure : Get all data on Table role , 
******************************************************************************/

IF EXISTS (SELECT * 
FROM sys.objects 
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_user_role]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_user_role];
END
GO
CREATE PROCEDURE [dbo].[get_all_user_role]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[user_role]
END
GO

PRINT 'Procedure get_all_user_role'
GO

/*******************************************************************************
*****************************************************************************/