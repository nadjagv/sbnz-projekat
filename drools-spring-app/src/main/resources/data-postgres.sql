--destionations

INSERT INTO destinations (deleted,location,price,proximity,airport,rent_a_car,beach,sightseeings,shops,restaurants,children_activities,type) values (false,'Barcelona, Spain',1,0,true,true,true,true,true,true,true,1);

--attractions

INSERT INTO attractions (deleted,destination_id,name,description,near_destination,tickets,child_friendly,type) values (false,1,'La Sagrada Familia','The Basilica i Temple Expiatori de la Sagrada Familia, also known as the Sagrada Familia, is a large unfinished minor basilica in the Eixample district of Barcelona, Catalonia, Spain, and is currently the largest unfinished Roman Catholic church.',true,true,true,5);
INSERT INTO attractions (deleted,destination_id,name,description,near_destination,tickets,child_friendly,type) values (false,1,'Park Guell','Parc Guell is a privatized park system composed of gardens and architectural elements located on Carmel Hill, in Barcelona, Catalonia, Spain.',false,true,true,1);
INSERT INTO attractions (deleted,destination_id,name,description,near_destination,tickets,child_friendly,type) values (false,1,'Barceloneta Beach','Bustling spot for sunbathing & swimming',true,false,true,0);
INSERT INTO attractions (deleted,destination_id,name,description,near_destination,tickets,child_friendly,type) values (false,1,'Maremagnum','Roomy retail mall offering a variety of clothing shops, homewares, electronics & restaurant options.',true,false,true,2);
INSERT INTO attractions (deleted,destination_id,name,description,near_destination,tickets,child_friendly,type) values (false,1,'Moog','Happening hangout for techno music, live concerts & dancing, as well as cocktails.',true,false,false,6);

--reviews

INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,1,5,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,1,4,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,1,2,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,2,4,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,3,2,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,4,4,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,5,4,'','2022-01-01 12:00');
INSERT INTO reviews (deleted,attraction_id,rating,text,date) values (false,5,1,'','2020-01-01 12:00');
