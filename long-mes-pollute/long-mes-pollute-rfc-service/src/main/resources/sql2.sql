
----tstatebar

insert into [zxmes].[dbo].[tstatebar] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values('1','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','出库');

 insert into [zxmes].[dbo].[tstatebar] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values('2','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','入库');
  
    insert into [zxmes].[dbo].[tstatebar] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values('3','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','缓存');

   insert into [zxmes].[dbo].[tstatebar] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values('4','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','OK');


insert into [zxmes].[dbo].[tstatebar] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values('5','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','防务OK');
  
 insert into [zxmes].[dbo].[tstatebar] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values('6','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','防务ERROR');
  
  --t_mattype
	  
insert into [zxmes].[dbo].[tmattype] ([id]
      ,[createdDateTime]
      ,[matTypeName]
      ,[modifyDateTime]
      ,[remark]
)values(3,'2017-03-27 11:06:36.9830000','未促','2017-03-27 11:06:36.9830000','');

	  insert into [zxmes].[dbo].[tmattype] ([id]
      ,[createdDateTime]
      ,[matTypeName]
      ,[modifyDateTime]
      ,[remark]
)values(4,'2017-03-27 11:06:36.9830000','加促','2017-03-27 11:06:36.9830000','');

insert into [zxmes].[dbo].[tmattype] ([id]
      ,[createdDateTime]
      ,[matTypeName]
      ,[modifyDateTime]
      ,[remark]
)values(5,'2017-03-27 11:06:36.9830000','药品','2017-03-27 11:06:36.9830000','');



--t_mattypeslz
	 
insert into [zxmes].[dbo].[tmattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values(5,'2017-03-27 11:06:36.9830000','S','2017-03-27 11:06:36.9830000','');


insert into [zxmes].[dbo].[tmattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values(6,'2017-03-27 11:06:36.9830000','L','2017-03-27 11:06:36.9830000','');

insert into [zxmes].[dbo].[tmattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values(7,'2017-03-27 11:06:36.9830000','Z','2017-03-27 11:06:36.9830000','');

  insert into [zxmes].[dbo].[tmattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values('8','2017-03-27 11:06:36.9830000','C','2017-03-27 11:06:36.9830000','');


--t_department
 insert into [zxmes].[dbo].[tdepartment] ([id]
      ,[createdDateTime]
      ,[departName]
      ,[modifyDateTime]
      ,[remark]
)values('0','2017-03-27 11:06:36.9830000','混练','2017-03-27 11:06:36.9830000','');



 --t_repertorylimit
 insert into [zxmes].[dbo].[trepertorylimit]([id]
      ,[createdDateTime]
      ,[limitName1]
      ,[modifyDateTime]
)values('0','2017-03-27 11:06:36.9830000','102','2017-03-27 11:06:36.9830000'),
('1','2017-03-27 11:06:36.9830000','202','2017-03-27 11:06:36.9830000'),
('2','2017-03-27 11:06:36.9830000','302','2017-03-27 11:06:36.9830000'),
('3','2017-03-27 11:06:36.9830000','502','2017-03-27 11:06:36.9830000')

update  [zxmes].[dbo].[trepertorylimit] set limitName2='未促'


insert into [zxmes].[dbo].[trepertorylimit]([id]
      ,[createdDateTime]
      ,[limitName1]
	  ,[limitName2]
      ,[modifyDateTime]
)values('4','2017-03-27 11:06:36.9830000','102','加促','2017-03-27 11:06:36.9830000'),
('5','2017-03-27 11:06:36.9830000','202','加促','2017-03-27 11:06:36.9830000'),
('6','2017-03-27 11:06:36.9830000','302','加促','2017-03-27 11:06:36.9830000'),
('7','2017-03-27 11:06:36.9830000','502A','加促','2017-03-27 11:06:36.9830000'),
('8','2017-03-27 11:06:36.9830000','502B','加促','2017-03-27 11:06:36.9830000')

---库区
select * into [zxmes].[dbo].[trepertory] from  springtest.dbo.t_repertory

insert  into [zxmes].[dbo].[trepertory] select * from  springtest.dbo.t_repertory

  
  