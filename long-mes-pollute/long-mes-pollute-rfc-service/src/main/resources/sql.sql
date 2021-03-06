--t_bar
insert into [SpringTest].[dbo].[t_bar] ([id],[createdDateTime]
      ,[endBatch]
      ,[matLot]
      ,[matName]
      ,[remainder]
      ,[remark]
      ,[shortBar]
      ,[starBatch])values(0,'2017-03-27 11:06:36.9830000',4,'20170101F06','8178',4,'','1700100000177',1);
      
      
  --t_repertory
  insert into [SpringTest].[dbo].[t_repertory] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[repertoryName])values(0,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','K18');
  
  
  --t_barstate
insert into [SpringTest].[dbo].[t_barstate] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values(1,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','出库');

 insert into [SpringTest].[dbo].[t_barstate] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values(2,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','入库');
  
    insert into [SpringTest].[dbo].[t_barstate] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values(3,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','缓存');

   insert into [SpringTest].[dbo].[t_barstate] ([id]
  ,[createdDateTime]
  ,[modifyDateTime]
  ,[remark]
  ,[stateName])values(4,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','','OK');
	  
--t_mattype
	  
insert into [SpringTest].[dbo].[t_mattype] ([id]
      ,[createdDateTime]
      ,[matTypeName]
      ,[modifyDateTime]
      ,[remark]
)values(3,'2017-03-27 11:06:36.9830000','未促','2017-03-27 11:06:36.9830000','');

	  insert into [SpringTest].[dbo].[t_mattype] ([id]
      ,[createdDateTime]
      ,[matTypeName]
      ,[modifyDateTime]
      ,[remark]
)values(4,'2017-03-27 11:06:36.9830000','加促','2017-03-27 11:06:36.9830000','');

insert into [SpringTest].[dbo].[t_mattype] ([id]
      ,[createdDateTime]
      ,[matTypeName]
      ,[modifyDateTime]
      ,[remark]
)values(5,'2017-03-27 11:06:36.9830000','药品','2017-03-27 11:06:36.9830000','');


--t_mattypeslz
	 
insert into [SpringTest].[dbo].[t_mattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values(5,'2017-03-27 11:06:36.9830000','S','2017-03-27 11:06:36.9830000','');


insert into [SpringTest].[dbo].[t_mattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values(6,'2017-03-27 11:06:36.9830000','L','2017-03-27 11:06:36.9830000','');

insert into [SpringTest].[dbo].[t_mattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values(7,'2017-03-27 11:06:36.9830000','Z','2017-03-27 11:06:36.9830000','');

  insert into [SpringTest].[dbo].[t_mattypeslz] ( [id]
      ,[createdDateTime]
      ,[matName]
      ,[modifyDateTime]
      ,[remark]
)values('8','2017-03-27 11:06:36.9830000','C','2017-03-27 11:06:36.9830000','');

--t_rfid

insert into [SpringTest].[dbo].[t_rfid] (
		[id]
      ,[createdDateTime]
      ,[modifyDateTime]
      ,[palletNo]
      ,[rfid]
)values(7,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','7648','1001 0000 0000 2014 1227 1456');

insert into [SpringTest].[dbo].[t_rfid] (
		[id]
      ,[createdDateTime]
      ,[modifyDateTime]
      ,[palletNo]
      ,[rfid]
)values(8,'2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','7572','1001 0000 0000 2014 1227 1458');

--外键与中间表

update [SpringTest].[dbo].[t_bar] set barstateId='2',matTypeId='3',matTypeSLZId='6'

insert into  [SpringTest].[dbo].[t_bar_repertory]([id]
      ,[createdDateTime]
      ,[barId]
      ,[repertoryId]) values('3','2017-03-27 11:06:36.9830000','0','0')

insert into  [SpringTest].[dbo].[t_bar_rfid]([id]
      ,[createdDateTime]
      ,[barId]
      ,[rfidId]) values('3','2017-03-27 11:06:36.9830000','0','7')
      
insert into  [SpringTest].[dbo].[t_bar_rfid]([id]
      ,[createdDateTime]
      ,[barId]
      ,[rfidId]) values('4','2017-03-28 11:06:36.9830000','0','8')
      
--t_department
 insert into [SpringTest].[dbo].[t_department] ([id]
      ,[createdDateTime]
      ,[departName]
      ,[modifyDateTime]
      ,[remark]
)values('0','2017-03-27 11:06:36.9830000','混练','2017-03-27 11:06:36.9830000','');
  
  
 --t_repertorylimit
 insert into [SpringTest].[dbo].[t_repertorylimit]([id]
      ,[createdDateTime]
      ,[limitName1]
      ,[modifyDateTime]
)values('0','2017-03-27 11:06:36.9830000','102','2017-03-27 11:06:36.9830000'),
('1','2017-03-27 11:06:36.9830000','202','2017-03-27 11:06:36.9830000'),
('2','2017-03-27 11:06:36.9830000','302','2017-03-27 11:06:36.9830000'),
('3','2017-03-27 11:06:36.9830000','502','2017-03-27 11:06:36.9830000')

update  [SpringTest].[dbo].[t_repertorylimit] set limitName2='未促'


insert into [SpringTest].[dbo].[t_repertorylimit]([id]
      ,[createdDateTime]
      ,[limitName1]
	  ,[limitName2]
      ,[modifyDateTime]
)values('4','2017-03-27 11:06:36.9830000','102','加促','2017-03-27 11:06:36.9830000'),
('5','2017-03-27 11:06:36.9830000','202','加促','2017-03-27 11:06:36.9830000'),
('6','2017-03-27 11:06:36.9830000','302','加促','2017-03-27 11:06:36.9830000'),
('7','2017-03-27 11:06:36.9830000','502A','加促','2017-03-27 11:06:36.9830000'),
('8','2017-03-27 11:06:36.9830000','502B','加促','2017-03-27 11:06:36.9830000')

















insert into [SpringTest].[dbo].[t_repertory] ([id]
      ,[createdDateTime]
      ,[modifyDateTime]
      ,[repertoryName]
	  ,[trepertorylimitId]
) values
('502W2','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W01不合格区','8'),
('502W3','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W02','8'),
('502W4','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W03','8'),
('502W5','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W04','8'),
('502W6','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W05','8'),
('502W7','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W06','8'),
('502W8','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W07','8'),
('502W9','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W08','8'),
('502W10','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W09','8'),
('502W11','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W10','8'),
('502W12','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W11','8'),
('502W13','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W12','8'),
('502W14','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W13','8'),
('502W15','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W14','8'),
('502W16','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W15','8'),
('502W17','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W16','8'),
('502W18','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W17','8'),
('502W19','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W18','8'),
('502W20','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W19','8'),
('502W21','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W20','8'),
('502W22','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W21','8'),
('502W23','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W22','8'),
('502W24','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W23','8'),
('502W25','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W24','8'),
('502W26','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W25','8'),
('502W27','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W26','8'),
('502W28','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W27','8'),
('502W29','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W28','8'),
('502W30','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W29','8'),
('502W31','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W30','8'),
('502W32','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W31','8'),
('502W33','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W32','8'),
('502W34','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W33','8'),
('502W35','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W34','8'),
('502W36','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W35','8'),
('502W37','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W36','8'),
('502W38','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W37','8'),
('502W39','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W38','8'),
('502W40','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W39','8'),
('502W41','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W40','8'),
('502W42','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W41','8'),
('502W43','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W42','8')
--('502W44','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W43','5'),
--('502W45','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W44','5'),
--('502W46','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W45','5'),
--('502W47','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W46','5'),
--('502W48','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W47','5'),
--('502W49','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W48','5'),
--('502W50','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W49','5'),
--('502W51','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W50','5'),
--('502W52','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W51','5'),
--('502W59','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W52','5'),
--('502W60','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W53','5'),
--('502W61','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','W54','5'),
--('502W62','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','8212F硫磺造料','5'),
--('502W63','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','202回收流程收料区','5'),
--('502W64','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','回收料放置区','5'),
--('502W647','2017-03-27 11:06:36.9830000','2017-03-27 11:06:36.9830000','试做区','5')

