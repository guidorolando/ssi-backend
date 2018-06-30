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


/*
*******************************************************************************
**                            Change History
*******************************************************************************
**  table  capacity
**   Date:     Author:                            Description:
** --------   --------        ---------------------------------------------------
** 25/06/2018 Henry  J . Calani A.   Initial version
*******************************************************************************/


----------------    Procedimientos almacenados Capacity  ------------------
PRINT 'Start of Script Execution....';
GO

-- Create InsertMaterial stored procedure.
IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[create_capacity]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[create_capacity]
END
GO

/****
************************************************************************
************    CREATE PROCEDURE  CREATE    ****************************
************                                ****************************
************         FOR CAPACITY           ****************************
************************************************************************
****/

CREATE PROCEDURE [dbo].[create_capacity]
(
	 @name VARCHAR(50)
	,@description VARCHAR(50)
	,@is_deleted  bit NULL
	,@id INT OUTPUT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN

	INSERT INTO [dbo].[Capacity](name
								,description
								,is_deleted
								,id)
	VALUES (@name
			,@description
			,@is_deleted
			,@id);

	SELECT @id = @@IDENTITY;
	PRINT @id;
END
GO
PRINT 'Procedure [dbo].[Capacity] created'
GO


/****
************************************************************************
************    CREATE PROCEDURE  UPDATE    ****************************
************                                ****************************
************         FOR CAPACITY           ****************************
************************************************************************
****/

-- Update Calacity  procedure.
IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[update_capacity]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[update_capacity]
END
GO
PRINT 'Procedure [dbo].[update_capacity] created complete'
GO

/****
************************************************************************
************    CREATE PROCEDURE  UPDATE    ****************************
************                                ****************************
************         FOR CAPACITY           ****************************
************************************************************************
****/


CREATE PROCEDURE [dbo].[update_capacity]
(

	 @id INT
	,@name VARCHAR(50)
	,@description VARCHAR(50)
	,@is_deleted  bit NULL



)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN

	UPDATE [dbo].[capacity] SET  name = @name
								,description = @description
								,is_deleted = @is_deleted
						     	WHERE id = @id;
END
GO
PRINT 'Procedure [dbo].[update_capacity] update complete'
GO


/****
**************************************************************************
************     PROCEDURE  GET ALL CAPACITY  ****************************
************                                  ****************************
************         FOR CAPACITY             ****************************
**************************************************************************
****/



IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_capacity]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_capacity];
END
GO


/****
==
== PROCEDURE GET ALL CAPACITY FOR PERSONAL
==
***/


CREATE PROCEDURE [dbo].[get_all_Capacity]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[capacity]
END
GO

PRINT 'Procedure get_all_capcity was created successfully  complete'
GO



/****
**************************************************************************
************     PROCEDURE  DELETE            ****************************
************                                  ****************************
************         FOR CAPACITY             ****************************
**************************************************************************
****/


IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[delete_capacity]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[delete_capacity];
END
GO


/****
**************************************************************************
************     PROCEDURE  DELETE            ****************************
************                                  ****************************
************         FOR CAPACITY             ****************************
**************************************************************************
****/


CREATE PROCEDURE [dbo].[delete_capacity]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    DELETE FROM [dbo].[capacity]
	WHERE id = @id;
END
GO

PRINT 'Procedure delete_capacity was created successfully complete'
GO


/*
*******************************************************************************
**
*******************************************************************************
** Table Personal_Information
**                            Change History
*******************************************************************************
**   Date:     Author:                            Description:
** --------   --------        ---------------------------------------------------
** 25/06/2018 Henry  J . Calani A.   Initial version
*******************************************************************************/


----------------    Procedimientos almacenados Capacity  ------------------
PRINT 'Start of Script Execution....';
GO

-- Create InsertMaterial stored procedure.
IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[create_personal_information]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[create_personal_information]
END
GO

/****
************************************************************************
************       PROCEDURE  CREATE        ****************************
************                                ****************************
************   FOR PERSONAL INFORMATION     ****************************
************************************************************************
****/




CREATE PROCEDURE [dbo].[create_personal_information]
(
	 @legal_name VARCHAR(50)
	,@area_id VARCHAR(50)
	,@capacity_id VARCHAR(50)
	,@registration_date VARCHAR(50)
	,@is_deleted  bit NULL
	,@id INT OUTPUT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN

	INSERT INTO [dbo].[personal_information](
	 legal_name
	,area_id
	,capacity_id
	,registration_date
	,is_deleted
	,id
								)
	VALUES (
	 @legal_name
	,@area_id
	,@capacity_id
	,@registration_date
	,@is_deleted
	,@id
	);

	SELECT @id = @@IDENTITY;
	PRINT @id;
END
GO
PRINT 'Procedure [dbo].[personal_information] created Final'
GO


/****
***************************************************************************
************    CREATE PROCEDURE  UPDATE       ****************************
************                                   ****************************
************     FOR PERSONAL INFORMATION      ****************************
***************************************************************************
****/

-- Update PersonalInformation  procedure.
IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[update_personal_information]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE [dbo].[update_personal_information]
END
GO
PRINT 'Procedure [dbo].[personal_information] created complete'
GO

/****
************************************************************************
************    CREATE PROCEDURE  UPDATE    ****************************
************                                ****************************
************         FOR PERSONAL INFORMATION           ****************************
************************************************************************
****/


CREATE PROCEDURE [dbo].[update_personal_information]
(
	 @id INT
	,@legal_name VARCHAR(50)
	,@area_id VARCHAR(50)
	,@capacity_id VARCHAR(50)
	,@registration_date VARCHAR(50)
	,@is_deleted  bit NULL


)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN

	UPDATE [dbo].[update_personal_information] SET
	                           legal_name = @legal_name
	                           ,area_id  = @area_id
	                           ,capacity_id = @capacity_id
	                           ,registration_date = @registration_date
	                           ,registration_date = @is_deleted
	                            WHERE id = @id;



END
GO
PRINT 'Procedure [dbo].[personal_information] update complete'
GO


/****
***************************************************************************
************     PROCEDURE  GET ALL CAPACITY   ****************************
************                                   ****************************
************         FOR PERSONAL INFORMATION  ****************************
***************************************************************************
****/



IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[get_all_personal_information]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[get_all_personal_information];
END
GO


/****
==
== PROCEDURE GET ALL CAPACITY FOR PERSONAL
==
***/


CREATE PROCEDURE [dbo].[get_all_personal_information]
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT * FROM [dbo].[personal_information]
END
GO

PRINT 'Procedure get_all_personal_information was created successfully  complete'
GO



/****
***************************************************************************
************     PROCEDURE  DELETE             ****************************
************                                   ****************************
************         FOR PERSONAL INFORMATION  ****************************
***************************************************************************
****/


IF EXISTS (SELECT *
FROM sys.objects
WHERE object_id = OBJECT_ID(N'[dbo].[delete_personal_information]')
AND type IN (N'P', N'PC'))
BEGIN
    DROP PROCEDURE [dbo].[delete_personal_information];
END
GO


/****
**************************************************************************
************     PROCEDURE  DELETE             ****************************
************                                   ****************************
************         FOR PERSONAL INFORMATION  ****************************
***************************************************************************
****/


CREATE PROCEDURE [dbo].[delete_personal_information]
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
    DELETE FROM [dbo].[personal_information]
	WHERE id = @id;
END
GO

PRINT 'Procedure delete_personal_information was created successfully complete'
GO





