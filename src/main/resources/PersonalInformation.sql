use ssi

CREATE TABLE PersonalInformationHistory(
	PersonalInformationHistoryID		BIGINT			IDENTITY(1,1) NOT NULL
	,UsersAddress			VARCHAR(30)		NOT NULL
	,PerformedAction		VARCHAR(20)		NOT NULL
	,ModificationDate		DATE			NOT NULL

	,personalInformationIDOld		BIGINT			NULL
	,legalNameOld		VARCHAR(30)			NULL
	,registrationDateOld			DATE				NULL
	,employeeIDOld			BIGINT			NULL
	,areaIDOld			BIGINT			NULL

	,personalInformationIDNew		BIGINT			NULL
	,legalNameNew		VARCHAR(30)			NULL
	,registrationDateNew			DATE				NULL
	,employeeIDNew			BIGINT			NULL
	,areaIDNew			BIGINT			NULL
	,CONSTRAINT Pk_PersonalInformationHistory PRIMARY KEY (PersonalInformationHistoryID)
)




/********************************
**	Name: TG_UpdateDeletePersonalInformation
**	Desc: Trigger para insertar el historial del PersonalInformation
**
**	Called by: Portal
**
**	Author: Marco Herrera Patzi, Henry Calani A. 
**
**	Date: 30/06/2018
*********************************
**					  				Change History
*********************************
**	Date:	 		Author:						Description:
** ----------	------------------------	---------------------------------------------------
** 01/07/2018	Marco Herrera Patzi, Henry Calani A.		Initial version
********************************/
IF OBJECT_ID('TG_UpdateDeletePersonalInformation') IS NOT NULL
BEGIN	
	print 'SQLServer> Preparando para la ejecucion de Trigger...';
	DROP TRIGGER TG_UpdateDeletePersonalInformation;
	print 'SQLServer> Ejecutando el Trigger...';	
END
ELSE
BEGIN
	print 'SQLServer> Ejecutando el Trigger...';
END
GO

CREATE TRIGGER TG_UpdateDeletePersonalInformation ON [dbo].[personal_information]
FOR INSERT, UPDATE, DELETE
AS
RETURN
SET NOCOUNT ON;
SET XACT_ABORT ON;
DECLARE
@ip_address varchar(30)
,@action varchar(20) 

,@personalInformationID bigint
,@legalName VARCHAR(30)
,@registrationDate date
,@employeeID bigint
,@areaID bigint

,@personalInformationIDOLd bigint
,@legalNameOld VARCHAR(30)
,@registrationDateOld date
,@employeeIDOld bigint
,@areaIDOld bigint
BEGIN
	IF EXISTS(SELECT * FROM inserted)
	BEGIN
		IF EXISTS(SELECT * FROM deleted)--Si es un update
		BEGIN
			SELECT @action='UPDATE';			
			SET @ip_address = (SELECT client_net_address FROM sys.dm_exec_connections    WHERE Session_id = @@SPID);
			SELECT top 1 @personalInformationIDOld=deleted.id,@legalNameOld=deleted.legal_name
			,@registrationDateOld=deleted.registration_date,@employeeIDOld=deleted.employee_id,@areaIDOld=deleted.area_id 
			from deleted;
			SELECT top 1 @personalInformationID=inserted.id,@legalName=inserted.legal_name
			,@registrationDate=inserted.registration_date,@employeeID=inserted.employee_id,@areaID=inserted.area_id 
			from inserted;

			INSERT INTO [dbo].[PersonalInformationHistory] (
				[UsersAddress],[PerformedAction],[ModificationDate]
				,[personalInformationIDOld],[legalNameOld],[registrationDateOld],[employeeIDOld],[areaIDOld]
				,[personalInformationIDNew],[legalNameNew],[registrationDateNew],[employeeIDNew],[areaIDNew]
			) VALUES(
					@ip_address,@action,GETDATE()
					,@personalInformationIDOld,@legalNameOld,@registrationDateOld,@employeeIDOld,@areaIDOld
					,@personalInformationID,@legalName,@registrationDate,@employeeID,@areaID
			);

		END
		ELSE
		BEGIN                              --Si es un insert
			SELECT @action='INSERT';
			SET @ip_address = (SELECT client_net_address FROM sys.dm_exec_connections    WHERE Session_id = @@SPID);
			(SELECT top 1 @personalInformationID=inserted.id,@legalName=inserted.legal_name
			,@registrationDate=inserted.registration_date,@employeeID=inserted.employee_id,@areaID=inserted.area_id 
			from inserted);
			
			INSERT INTO [dbo].[PersonalInformationHistory] (
				[UsersAddress],[PerformedAction],[ModificationDate]
				,[personalInformationIDOld],[legalNameOld],[registrationDateOld],[employeeIDOld],[areaIDOld]
				,[personalInformationIDNew],[legalNameNew],[registrationDateNew],[employeeIDNew],[areaIDNew]
			) VALUES(
					@ip_address,@action,GETDATE()
					,NULL,NULL,NULL,NULL,NULL
					,@personalInformationID,@legalName,@registrationDate,@employeeID,@areaID
			);
		END
	END
	ELSE
	BEGIN                                --si es un delete
		SELECT @action='DELETE';
		SET @ip_address = (SELECT client_net_address FROM sys.dm_exec_connections    WHERE Session_id = @@SPID);
		SELECT top 1 @personalInformationIDOld=deleted.id,@legalNameOld=deleted.legal_name
			,@registrationDateOld=deleted.registration_date,@employeeIDOld=deleted.employee_id,@areaIDOld=deleted.area_id 
			from deleted;
			SELECT top 1 @personalInformationID=inserted.id,@legalName=inserted.legal_name
			,@registrationDate=inserted.registration_date,@employeeID=inserted.employee_id,@areaID=inserted.area_id 
			from inserted;

		INSERT INTO [dbo].[PersonalInformationHistory] (
			[UsersAddress],[PerformedAction],[ModificationDate]
			,[personalInformationIDOld],[legalNameOld],[registrationDateOld],[employeeIDOld],[areaIDOld]
			,[personalInformationIDNew],[legalNameNew],[registrationDateNew],[employeeIDNew],[areaIDNew]
		) VALUES(
				@ip_address,@action,GETDATE()
				,@personalInformationIDOld,@legalNameOld,@registrationDateOld,@employeeIDOld,@areaIDOld
				,@personalInformationID,@legalName,@registrationDate,@employeeID,@areaID
		);
	END
	
END
GO