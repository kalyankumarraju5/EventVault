select * from event;

INSERT INTO event (event_id, title, description) VALUES (1, 'Tech Conference', 'A conference about the latest in technology advancements and trends.');
INSERT INTO event (event_id, title, description) VALUES (2, 'Art Exhibition', 'An exhibition showcasing modern and contemporary art from around the world.');
INSERT INTO event (event_id, title, description) VALUES (3, 'Music Festival', 'A summer music festival featuring a wide range of musical genres and popular artists.');
INSERT INTO event (event_id, title, description) VALUES (4, 'Business Seminar', 'A seminar focused on strategies for starting and growing a successful business in the current economic climate.');
INSERT INTO event (event_id, title, description) VALUES (5, 'Health and Wellness Fair', 'A fair promoting health and wellness with workshops, fitness classes, and health screenings.');
INSERT INTO event (event_id, title, description) VALUES (6, 'Local Food Expo', 'Discover local flavors and meet the producers behind the best home-grown food products.');
INSERT INTO event (event_id, title, description) VALUES (7, 'Charity Run', 'Join the annual 5K run to raise funds for local charities focused on children’s health and education.');
INSERT INTO event (event_id, title, description) VALUES (8, 'Vintage Car Show', 'A showcase of classic and vintage cars from collectors in the region, featuring models from the early 20th century.');
INSERT INTO event (event_id, title, description) VALUES (9, 'DIY Crafts Workshop', 'A weekend workshop on DIY crafts including pottery, knitting, and upcycling projects.');
INSERT INTO event (event_id, title, description) VALUES (10, 'Real Estate Investing Seminar', 'Learn about the latest trends in real estate investment and meet industry experts.');
INSERT INTO event (event_id, title, description) VALUES (11, 'Annual Book Fair', 'Explore thousands of books from hundreds of authors. Signings, readings, and panels included.');
INSERT INTO event (event_id, title, description) VALUES (12, 'Eco Living Festival', 'A festival promoting sustainable living with workshops on zero waste, sustainable agriculture, and renewable energy.');
INSERT INTO event (event_id, title, description) VALUES (13, 'Film Festival', 'Screenings of international indie films followed by Q&A sessions with directors and cast members.');
INSERT INTO event (event_id, title, description) VALUES (14, 'Fashion Week', 'A week-long celebration of fashion with runway shows, designer meet-and-greets, and pop-up shops.');
INSERT INTO event (event_id, title, description) VALUES (15, 'Cyber Security Conference', 'A comprehensive conference on the latest in cybersecurity technologies and strategies.');
INSERT INTO event (event_id, title, description) VALUES (16, 'Jazz Night', 'Enjoy a night of smooth jazz from renowned musicians in a cozy downtown venue.');
INSERT INTO event (event_id, title, description) VALUES (17, 'Historical Reenactment Day', 'Step back in time with reenactments from key historical events and battles.');
INSERT INTO event (event_id, title, description) VALUES (18, 'Tech Hackathon', 'A 48-hour hackathon challenging developers to create innovative tech solutions.');
INSERT INTO event (event_id, title, description) VALUES (19, 'Healthcare Innovations Symposium', 'A symposium discussing breakthroughs in healthcare technology, treatments, and management.');
INSERT INTO event (event_id, title, description) VALUES (20, 'Youth Art Competition', 'A competition and exhibition showcasing the talents of young artists in the community.');


select * from attendee;

INSERT INTO attendee (attendee_id, name, email) VALUES (1, 'Michael Johnson', 'michael.johnson@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (2, 'Sara Miller', 'sara.miller@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (3, 'James Lee', 'james.lee@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (4, 'Emily Taylor', 'emily.taylor@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (5, 'David Brown', 'david.brown@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (6, 'Jessica Garcia', 'jessica.garcia@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (7, 'Chris Moore', 'chris.moore@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (8, 'Patricia Johnson', 'patricia.johnson@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (9, 'Daniel Martinez', 'daniel.martinez@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (10, 'Laura Lee', 'laura.lee@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (11, 'John Smith', 'john.smith@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (12, 'Karen Hill', 'karen.hill@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (13, 'Brian Clark', 'brian.clark@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (14, 'Nora Roberts', 'nora.roberts@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (15, 'Richard Lewis', 'richard.lewis@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (16, 'Sophia Turner', 'sophia.turner@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (17, 'Aaron Carter', 'aaron.carter@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (18, 'Lily Brooks', 'lily.brooks@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (19, 'Kevin Murphy', 'kevin.murphy@example.com');
INSERT INTO attendee (attendee_id, name, email) VALUES (20, 'Isabella Foster', 'isabella.foster@example.com');


select * from organizer;

INSERT INTO organizer (organizer_id, name) VALUES (1, 'Alice Johnson');
INSERT INTO organizer (organizer_id, name) VALUES (2, 'Bob Smith');
INSERT INTO organizer (organizer_id, name) VALUES (3, 'Carol Taylor');
INSERT INTO organizer (organizer_id, name) VALUES (4, 'David Lee');
INSERT INTO organizer (organizer_id, name) VALUES (5, 'Eva Green');
INSERT INTO organizer (organizer_id, name) VALUES (6, 'Frank White');
INSERT INTO organizer (organizer_id, name) VALUES (7, 'Grace Hall');
INSERT INTO organizer (organizer_id, name) VALUES (8, 'Henry Allen');
INSERT INTO organizer (organizer_id, name) VALUES (9, 'Isabella Morris');
INSERT INTO organizer (organizer_id, name) VALUES (10, 'Jack Carter');
INSERT INTO organizer (organizer_id, name) VALUES (11, 'Kathy Long');
INSERT INTO organizer (organizer_id, name) VALUES (12, 'Leo Clark');
INSERT INTO organizer (organizer_id, name) VALUES (13, 'Mia Hill');
INSERT INTO organizer (organizer_id, name) VALUES (14, 'Nolan Edwards');
INSERT INTO organizer (organizer_id, name) VALUES (15, 'Olivia Martin');
INSERT INTO organizer (organizer_id, name) VALUES (16, 'Peter Wright');
INSERT INTO organizer (organizer_id, name) VALUES (17, 'Quinn Young');
INSERT INTO organizer (organizer_id, name) VALUES (18, 'Rachel King');
INSERT INTO organizer (organizer_id, name) VALUES (19, 'Steve Foster');
INSERT INTO organizer (organizer_id, name) VALUES (20, 'Tina Adams');


select * from ticket;