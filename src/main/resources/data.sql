insert into air_companies (company_type,founded_at,name)
values('Type','2000-11-21','Name');

insert into air_companies (company_type,founded_at,name)
values('Type','2000-01-21','Newcompany');

INSERT INTO `aircompanies`.`airplanes` (`created_at`, `factory_serial_number`, `flight_distance`, `fuel_capacity`, `name`, `number_of_flights`, `type`, `air_company_id`)
VALUES ('2015-05-24', '10', '10000', '1000', 'Boeing 737 800', '1000', 'Commercial ', '1');

INSERT INTO `aircompanies`.`airplanes` (`created_at`, `factory_serial_number`, `flight_distance`, `fuel_capacity`, `name`, `number_of_flights`, `type`, `air_company_id`)
VALUES ('2014-05-24', '8', '11000', '1000', 'Boeing 737 800', '5000', 'Commercial ', '1');



INSERT INTO `aircompanies`.`flights` ( `departure_country`, `destination_country`, `distance`,`estimated_flight_time`, `status`, `air_company_id`, `airplane_id`)
VALUES ( 'Kyiv', 'Italy', '2360',5,'PENDING', 1, 1);
