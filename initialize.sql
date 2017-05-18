	INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Marco','Polo', 'M', 10, 'marco_polo@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('John','Smith', 'M', 95, 'john_smith@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Flavio','Villanustre', 'M', 55, 'Flavio_v@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Jacob','Chacko', 'M', 41, 'jacob_chacko@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Jasmine','A', 'F', 21, 'jasmine_a@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Mulan','f', 'F', 17, 'mulan_f@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('GrandMa','Old', 'F', 98, 'grandma_old@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Heidi','T', 'F', 10, 'heidi_tobias@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('granny','fox', 'F', 68, 'granny_fox@gmail.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Aladin','Ho', 'M', 21, 'Aladin_ho@yahoo.com');
    INSERT INTO  PATIENTS(fname,lname,gender, age,email) values('Adrian','Am', 'M', 21, 'Adrian@yahoo.com');
	INSERT INTO  PATIENTS(fname,lname,gender, age,email) VALUES ('TwinJoe', 'Smith', 'M', 95, 'joe.smith@gmail.com');
	
    INSERT INTO  symptoms(sname) values('HeadAche');
    INSERT INTO  symptoms(sname) values('Pain');
    INSERT INTO  symptoms(sname) values('Fever');
    INSERT INTO  symptoms(sname) values('Swelling');
    INSERT INTO  symptoms(sname) values('Fatigue');
    INSERT INTO  symptoms(sname) values('Sore Throat');
    INSERT INTO  symptoms(sname) values('Cramps');
    INSERT INTO  symptoms(sname) values('Lumps');
    INSERT INTO  symptoms(sname) values('Bloating');
     INSERT INTO  symptoms(sname) values('Cough');
    
	ALTER TABLE Conditions AUTO_INCREMENT=1;
	INSERT INTO  Conditions(cname) values('Flu');
    INSERT INTO  Conditions(cname) values('Cancer');	
    INSERT INTO  Conditions(cname) values('Diabetes');
    INSERT INTO  Conditions(cname) values('Asthma');
    INSERT INTO  Conditions(cname) values('Hypertension');
    INSERT INTO  Conditions(cname) values('Thyroiditis');
    INSERT INTO  Conditions(cname) values('Ulcer');
    INSERT INTO  Conditions(cname) values('Arthritis');
    INSERT INTO  Conditions(cname) values('Tumour');
    INSERT INTO  Conditions(cname) values('Autism');
    

	INSERT INTO  Treatments(tname) values('Acupuncture');
    INSERT INTO  Treatments(tname) values('Homeopathy');
    INSERT INTO  Treatments(tname) values('Internal Medicine');
    INSERT INTO  Treatments(tname) values('Physical therapy');
    INSERT INTO  Treatments(tname) values('Ayurveda');
    INSERT INTO  Treatments(tname) values('Analgesia');
    INSERT INTO  Treatments(tname) values('Chemotherapy');
    INSERT INTO  Treatments(tname) values('Surgery');
    INSERT INTO  Treatments(tname) values('Speech Therapy');
    INSERT INTO  Treatments(tname) values('Gene Therapy');
    
        
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(001, 3, '2015-01-01', '2015-01-05');
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(001, 3, '2015-05-26', '2015-05-29');
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(001, 3, '2015-08-10', '2015-01-11');
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(001, 6, '2015-11-23', '2015-01-26');
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(001, 6, '2015-01-01', '2015-01-05');
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(004, 5, '2015-11-23', null);
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(004, 10, '2015-12-01', null);
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(005, 5, '2015-11-19', null);
INSERT INTO  PatientSymptomHistory(pid,sid,startdate, enddate) values(005, 10, '2015-11-29', null);

INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(001, 1, '2015-01-01', '2015-01-05');
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(001, 1, '2015-05-26', '2015-05-29');
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(001, 1, '2015-01-10', '2015-01-11');
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(001, 1, '2015-01-23', '2015-01-26');

INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(001, 2, '2015-01-01', '2015-01-05');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(001, 2, '2015-05-26', '2015-05-29');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(001, 3, '2011-08-10', '2015-11-11');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(12, 3, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(9, 3, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(7, 3, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(3, 3, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(2, 3, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(1, 3, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(9, 4, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(7, 4, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(3, 4, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(2, 4, '2015-01-23', '2015-01-26');
INSERT INTO  patienttreatmenthistory(pid,tid,startdate, enddate) values(1, 4, '2015-01-23', '2015-01-26');


INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(003, 3, '2015-11-23', '2015-01-26');
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(003, 5, '2012-09-23', null);
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(007, 3, '2007-06-12', null);
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(007, 5, '2008-07-12', null);
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(007, 4, '2007-06-21', null);
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(007, 8, '2007-04-12', null);
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(009, 3, '2010-01-19', '2010-01-26');
INSERT INTO  patientconditionhistory(pid,cid,startdate, enddate) values(009, 3, '2015-11-23', null);

INSERT INTO sampledb.messages (msgSubject,sender, receiver, content, sendTime) VALUES ('Diabeteics Help', 3, 9, 'How are you today.I wouldlike toknow abt your diabetic Treatments', '2015-01-01 10:00:00');
INSERT INTO sampledb.messages (msgSubject,sender, receiver, content, sendTime) VALUES  ('RE:Diabeteics Help', 9, 3, 'Good.Iam taking Homeopathy now.Do you want to know the details', '2015-01-01 10:00:00');
INSERT INTO sampledb.messages (msgSubject,sender, receiver, content, sendTime) VALUES  ('Sore Throat', 6, 7, 'How are you today.Do you know any remedy to Sore Throat ','2013-08-01 12:00:00');
INSERT INTO sampledb.messages (msgSubject,sender, receiver, content, sendTime) VALUES  ('Cramps',9 , 2, 'I took a new treatment for Cramps', '2015-11-01 10:00:00');
INSERT INTO sampledb.messages (msgSubject,sender, receiver, content, sendTime) VALUES  ('Hi', 8, 1, 'Hi.How are you today?', '2015-10-01 06:40:47');
INSERT INTO sampledb.messages (msgSubject,sender, receiver, content, sendTime) VALUES  ('RE:Hi', 8, 1, 'Hi.How are you today?', NOW());