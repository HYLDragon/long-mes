----创建数据库
CREATE DATABASE [pollute];
----创建caretype表
CREATE TABLE [dbo].[CARETYPE] (
	[ID] varchar(36) NOT NULL PRIMARY KEY,
	[NAME] varchar(50) NOT NULL,
	[REMARK] varchar(150)
)
GO
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'主键',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARETYPE',@level2type=N'Column',@level2name=N'ID';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'保养类型名称',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARETYPE',@level2type=N'Column',@level2name=N'NAME';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'此条记录的详细说明',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARETYPE',@level2type=N'Column',@level2name=N'REMARK';
GO

----创建保养表
CREATE TABLE [dbo].[CARE] (
	[ID] varchar(36) NOT NULL PRIMARY KEY,
	[NAME] varchar(50),
	[CREATEDATETIME] datetime,
	[MODIFYDATETIME] datetime,
	[REMARK] varchar(150),
	[CARETYPE_ID] varchar(36),
	FOREIGN KEY ([CARETYPE_ID])
		REFERENCES [dbo].[CARETYPE] ([ID])
		ON UPDATE NO ACTION ON DELETE NO ACTION
)
GO
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'主键',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARE',@level2type=N'Column',@level2name=N'ID';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'保养记录名称',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARE',@level2type=N'Column',@level2name=N'NAME';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'创建此条记录的时间',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARE',@level2type=N'Column',@level2name=N'CREATEDATETIME';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'记录这条记录最后一次修改时间',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARE',@level2type=N'Column',@level2name=N'MODIFYDATETIME';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'对这条记录做详细说明',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARE',@level2type=N'Column',@level2name=N'REMARK';
EXEC sp_addextendedproperty @name=N'MS_Description',@value=N'CARETYPE中ID对应的外键',@level0type=N'Schema',@level0name=N'dbo',@level1type=N'Table',@level1name=N'CARE',@level2type=N'Column',@level2name=N'CARETYPE_ID';
GO

----向CareType表中插入数据
INSERT INTO [CARETYPE] ([ID],[NAME],[REMARK]) VALUES (N'0',N'VP香片更换',NULL);
INSERT INTO [CARETYPE] ([ID],[NAME],[REMARK]) VALUES (N'1',N'风机机油添加',NULL);
INSERT INTO [CARETYPE] ([ID],[NAME],[REMARK]) VALUES (N'2',N'除尘设备滤网更换',NULL);
INSERT INTO [CARETYPE] ([ID],[NAME],[REMARK]) VALUES (N'3',N'UV前置滤网更换',NULL);