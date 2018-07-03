DROP database if exists Horario;
Create database Horario;
Use Horario;

Create Table OfertaEducativa (
	CodOe char(3) PRIMARY KEY,
	Nombre varchar(70),
	Descripcion varchar(255),
	Tipo enum ('CFGS','CFGM','FPB','ESO','BACH'),
	FechaLey date
	);
Create Table Profesor(
	CodProf char(3) PRIMARY KEY,
	Nombre varchar(20),
	Apellidos varchar(40),
	FechaAlta timestamp
	);
Create TABLE Curso(
	CodOe char(3),
    	CodCurso char(2),
	Tutor char(3) unique NOT NULL,
	FOREIGN KEY (CodOe) REFERENCES OfertaEducativa (CodOe) ON DELETE CASCADE ON UPDATE Cascade,
	FOREIGN KEY (Tutor) REFERENCES Profesor (CodProf) ON DELETE RESTRICT ON UPDATE CASCADE, 
	PRIMARY KEY (CodOe, CodCurso)
	);
Create TABLE TramoHorario(
	CodTramo char(2) PRIMARY KEY,
	HoraInicio time,
	HoraFin time,
	Dia enum ('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES')
	);
CREATE TABLE Asignatura(
	CodAsignatura varchar(5) PRIMARY KEY,
	Nombre varchar(80),
	HorasSemanales tinyint unsigned,
	HorasTotales smallint unsigned
	);
CREATE TABLE Reparto(
	CodOe char(3),
	CodCurso char(2), 
	CodAsignatura varchar(5),
	CodProf char(3),
	FOREIGN KEY (CodOe, CodCurso) REFERENCES Curso(CodOe, CodCurso) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (CodAsignatura) REFERENCES Asignatura(CodAsignatura) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (CodProf) REFERENCES Profesor (CodProf) ON DELETE RESTRICT ON UPDATE CASCADE,
	PRIMARY KEY(CodOe, CodCurso, CodAsignatura)
    );
Create TABLE Horario(
	CodTramo char(2),
	CodOe char(3),
	CodCurso char(2), 
	CodAsignatura varchar(5),
	FOREIGN KEY (CodOe, CodCurso) REFERENCES Curso(CodOe, CodCurso) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (CodAsignatura) REFERENCES Asignatura(CodAsignatura) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (CodTramo) REFERENCES TramoHorario (CodTramo) On DELETE CASCADE ON UPDATE CASCADE,
	PRIMARY KEY (CodOe, CodCurso, CodAsignatura, CodTramo)
	);

INSERT INTO OfertaEducativa VALUES 
("SMR","Grado Medio de Sistemas Microinformáticos y Redes","El CFGM SMR tiene una duración de 2000 horas 
 repartidas entre dos cursos académicos incluyendo un trimestre de Formacion en centros de trabajo (FCT)
 en empresas del Sector",'CFGM','2009-07-07'),
("DAM","Grado Superior de Desarollo de Aplicaciones Multiplataforma","El CFGs DAM tiene una duración de 2000 horas repartidas entre dos cursos académicos incluyendo 400 horas de Formacion en centros de trabajo (FCT) en empresas del Sector",'CFGS','2011-06-16');

INSERT INTO Profesor VALUES
("AGL","Ana","Gutiérrez Lozano",'1999-09-01'),
("PJM","Pedro","Joya Máñez",'2000-09-01'),
("EPM","Eva","Peralta Macías",'2009-09-01'),
("MPG","Manuel Jesús","Padilla Gutiérrez",'2016-09-01'),
("JGG","Javier","Graña González",'2011-09-01'),
("PBG","Pilar","Baena García",'2007-09-01'),
("SAA","Santiago","Acha Aller",'2006-09-01'),
("DPD","Domingo","Pérez Duque",'2016-09-01'),
("CJC","Carmen","Jurado Cano",'2016-09-01'),
("GHC","Guillermo","Hierrezuelo Conde",'2016-09-01'),
("JMG","Joaquín","Moreno Gallardo",'2016-09-01');							

INSERT INTO Curso VALUES
("SMR","1A","CJC"),
("SMR","2A","JGG"),
("DAM","1A","AGL"),
("DAM","2A","SAA");

INSERT INTO Asignatura VALUES 
("RED", "Redes Locales", 7,224),
("@RED", "Desdoble de Redes Locales", 3,224),
("SISM", "Sistemas operativos monopuestos", 5,160),
("MONT", "Montaje y mantenimiento de equipos", 7,224),
("@MONT", "Desdoble de Montaje y mantenimiento de equipos", 3,224),
("APLI", "Aplicaciones ofimáticas", 8, 256),
("@APLI", "Desdoble de Aplicaciones ofimáticas", 4, 256),
("SEG", "Seguridad informática", 5,105),
("HLC", "Horas de Libre Configuración", 3,63),
("SISR", "Sistemas operativos en red",7,147),
("SERV","Servicios en red",7,147),
("APLIW","Aplicaciones web",4,84),
("EIEM", "Empresa e iniciativa empresarial", 4,84),
("SIST","Sistemas informáticos",6,192),
("@SIST","Desdoble de Sistemas informáticos",3,192),
("BDD","Bases de Datos",6,192),
("@BDD","Desdoble de Bases de Datos",3,192),
("PROG","Programación",8, 256),
("@PROG","Desdoble de Programación",6, 256),
("ENT","Entornos de desarrollo",3,96),
("MARC","Lenguajes de marcas y sistemas de gestión de información", 4,128),
("FOL","Formación y orientación laboral",3,96),
("AD","Acceso a datos",5,105),
("DI","Desarrollo de interfaces",7,147),
("PSPRO","Programación de servicios y procesos",3,63),
("PMDMO","Programación multimedia y dispositivos móviles",4,84),
("EIE","Empresa e iniciativa emprendedora",4,84),
("SGE","Sistemas de gestión empresarial",4,84);

INSERT INTO TramoHorario VALUES
("L1", "08:15:00", "09:15:00", 'LUNES'), ("L2", "09:15:00", "10:15:00", 'LUNES'), ("L3", "10:15:00", "11:15:00", 'LUNES'), 
("L4", "11:45:00", "12:45:00", 'LUNES'), ("L5", "12:45:00", "13:45:00", 'LUNES'), ("L6", "13:45:00", "14:45:00", 'LUNES'), 
("M1", "08:15:00", "09:15:00", 'MARTES'), ("M2", "09:15:00", "10:15:00", 'MARTES'), ("M3", "10:15:00", "11:15:00", 'MARTES'), 
("M4", "11:45:00", "12:45:00", 'MARTES'), ("M5", "12:45:00", "13:45:00", 'MARTES'), ("M6", "13:45:00", "14:45:00", 'MARTES'), 
("X1", "08:15:00", "09:15:00", 'MIERCOLES'), ("X2", "09:15:00", "10:15:00", 'MIERCOLES'), ("X3", "10:15:00", "11:15:00", 'MIERCOLES'), 
("X4", "11:45:00", "12:45:00", 'MIERCOLES'), ("X5", "12:45:00", "13:45:00", 'MIERCOLES'), ("X6", "13:45:00", "14:45:00", 'MIERCOLES'), 
("J1", "08:15:00", "09:15:00", 'JUEVES'), ("J2", "09:15:00", "10:15:00", 'JUEVES'), ("J3", "10:15:00", "11:15:00", 'JUEVES'), 
("J4", "11:45:00", "12:45:00", 'JUEVES'), ("J5", "12:45:00", "13:45:00", 'JUEVES'), ("J6", "13:45:00", "14:45:00", 'JUEVES'), 
("V1", "08:15:00", "09:15:00", 'VIERNES'), ("V2", "09:15:00", "10:15:00", 'VIERNES'), ("V3", "10:15:00", "11:15:00", 'VIERNES'), 
("V4", "11:45:00", "12:45:00", 'VIERNES'), ("V5", "12:45:00", "13:45:00", 'VIERNES'), ("V6", "13:45:00", "14:45:00", 'VIERNES');

								
INSERT INTO Reparto VALUES
("SMR","1A","RED","JGG"),("SMR","1A","@RED","DPD"),("SMR","1A","SISM","MPG"),
("SMR","1A","MONT","MPG"),("SMR","1A","@MONT","SAA"),("SMR","1A","APLI","CJC"),
("SMR","1A","@APLI","PBG"),("SMR","1A","FOL","GHC"),("SMR","2A","SEG","AGL"),
("SMR","2A","HLC","JGG"),("SMR","2A","SISR","PBG"),("SMR","2A","SERV","JGG"),
("SMR","2A","APLIW","PJM"),("SMR","2A","EIEM","GHC"),("DAM","1A","SIST","CJC"),
("DAM","1A","@SIST","PBG"),("DAM","1A","BDD","AGL"),("DAM","1A","@BDD","PJM"),
("DAM","1A","PROG","EPM"),("DAM","1A","@PROG","AGL"),("DAM","1A","ENT","JGG"),
("DAM","1A","MARC","DPD"),("DAM","1A","FOL","GHC"),("DAM","2A","AD","EPM"),
("DAM","2A","DI","SAA"),("DAM","2A","PSPRO","PJM"),("DAM","2A","PMDMO","PJM"),
("DAM","2A","EIE","GHC"),("DAM","2A","SGE","CJC"),("DAM","2A","HLC","DPD");

INSERT INTO Horario VALUES

("L1","DAM","1A","PROG"),("L2","DAM","1A","SIST"),("L3","DAM","1A","FOL"),
("M1","DAM","1A","ENT"),("M2","DAM","1A","PROG"),("M3","DAM","1A","SIST"),
("X1","DAM","1A","MARC"),("X2","DAM","1A","BDD"),("X3","DAM","1A","BDD"),
("J1","DAM","1A","FOL"),("J2","DAM","1A","BDD"),("J3","DAM","1A","PROG"),
("V1","DAM","1A","BDD"),("V2","DAM","1A","BDD"),("V3","DAM","1A","SIST"),
("L4","DAM","1A","PROG"),("L5","DAM","1A","MARC"),("L6","DAM","1A","SIST"),
("M4","DAM","1A","FOL"),("M5","DAM","1A","MARC"),("M6","DAM","1A","SIST"),
("X4","DAM","1A","PROG"),("X5","DAM","1A","SIST"),("X6","DAM","1A","ENT"),
("J4","DAM","1A","PROG"),("J5","DAM","1A","MARC"),("J6","DAM","1A","BDD"),
("V4","DAM","1A","PROG"),("V5","DAM","1A","PROG"),("V6","DAM","1A","ENT"),
("X2","DAM","1A","@BDD"),("X3","DAM","1A","@BDD"),("J2","DAM","1A","@BDD"),
("L1","DAM","1A","@PROG"),("M2","DAM","1A","@PROG"),("X4","DAM","1A","@PROG"),
("J3","DAM","1A","@PROG"),("J4","DAM","1A","@PROG"),("V4","DAM","1A","@PROG"),
("L2","DAM","1A","@SIST"),("M3","DAM","1A","@SIST"),("V3","DAM","1A","@SIST"),

("L1","SMR","1A","APLI"),("L2","SMR","1A","SISM"),("L3","SMR","1A","MONT"),
("M1","SMR","1A","MONT"),("M2","SMR","1A","MONT"),("M2","SMR","1A","@MONT"),("M3","SMR","1A","MONT"),("M3","SMR","1A","@MONT"),
("X1","SMR","1A","APLI"),("X2","SMR","1A","SISM"),("X3","SMR","1A","SISM"),
("J1","SMR","1A","RED"),("J2","SMR","1A","RED"),("J3","SMR","1A","SISM"),
("V1","SMR","1A","RED"),("V2","SMR","1A","RED"),("V3","SMR","1A","RED"),("V3","SMR","1A","@RED"),
("L4","SMR","1A","RED"),("L4","SMR","1A","@RED"),("L5","SMR","1A","FOL"),("L6","SMR","1A","MONT"),("L6","SMR","1A","@MONT"),
("M4","SMR","1A","APLI"),("M4","SMR","1A","@APLI"),("M5","SMR","1A","SISM"),("M6","SMR","1A","RED"),("M6","SMR","1A","@RED"),
("X4","SMR","1A","APLI"),("X4","SMR","1A","@APLI"),("X5","SMR","1A","FOL"),("X6","SMR","1A","MONT"),
("J4","SMR","1A","APLI"),("J4","SMR","1A","@APLI"),("J5","SMR","1A","MONT"),("J6","SMR","1A","APLI"),
("V4","SMR","1A","APLI"),("V4","SMR","1A","@APLI"),("V5","SMR","1A","APLI"),("V6","SMR","1A","FOL"),

("L1","SMR","2A","SISR"),("L2","SMR","2A","EIEM"),("L3","SMR","2A","SEG"),
("L4","SMR","2A","APLIW"),("L5","SMR","2A","HLC"),("L6","SMR","2A","SERV"),
("M1","SMR","2A","SISR"),("M2","SMR","2A","HLC"),("M3","SMR","2A","SEG"),
("M4","SMR","2A","SERV"),("M5","SMR","2A","SERV"),("M6","SMR","2A","APLIW"),
("X1","SMR","2A","SISR"),("X2","SMR","2A","SISR"),("X3","SMR","2A","EIEM"),
("X4","SMR","2A","APLIW"),("X5","SMR","2A","SERV"),("X6","SMR","2A","SEG"),
("J1","SMR","2A","APLIW"),("J2","SMR","2A","EIEM"),("J3","SMR","2A","HLC"),
("J4","SMR","2A","SERV"),("J5","SMR","2A","SEG"),("J6","SMR","2A","SISR"),
("V1","SMR","2A","SISR"),("V2","SMR","2A","SISR"),("V3","SMR","2A","EIEM"),
("V4","SMR","2A","SERV"),("V5","SMR","2A","SERV"),("V6","SMR","2A","SEG"),

("L1","DAM","2A","PSPRO"),
("L2","DAM","2A","AD"),
("L3","DAM","2A","AD"),
("L4","DAM","2A","DI"),
("L5","DAM","2A","DI"),
("L6","DAM","2A","EIE"),
("M1","DAM","2A","SGE"),
("M2","DAM","2A","PMDMO"),
("M3","DAM","2A","PMDMO"),
("M4","DAM","2A","HLC"),
("M5","DAM","2A","PSPRO"),
("M6","DAM","2A","DI"),
("J1","DAM","2A","AD"),
("J2","DAM","2A","AD"),
("J3","DAM","2A","EIE"),
("J4","DAM","2A","HLC"),
("J5","DAM","2A","SGE"),
("J6","DAM","2A","DI"),                         
("X1","DAM","2A","PSPRO"),
("X2","DAM","2A","HLC"),
("X3","DAM","2A","DI"),
("X4","DAM","2A","EIE"),
("X5","DAM","2A","AD"),
("X6","DAM","2A","SGE"),
("V1","DAM","2A","EIE"),
("V2","DAM","2A","PMDMO"),
("V3","DAM","2A","PMDMO"),
("V4","DAM","2A","DI"),
("V5","DAM","2A","DI"),
("V6","DAM","2A","SGE");