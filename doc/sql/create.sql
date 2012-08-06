SET GLOBAL max_allowed_packet = 1024 * 1024 * 32;
SET SESSION max_allowed_packet = 1024 * 1024 * 32;

create table Test
(
	id varchar( 32 ),
	title varchar( 256 )
);
