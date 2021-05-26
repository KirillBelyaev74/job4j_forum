insert into authority (authority) values ('ROLE_USER');

insert into users (username, password, authority_id)
values ('user', '$2a$10$Mpwd78psdMERocWcrxJ4g.IKuUlmJt9x4nV4x8fvfWi1Ma2nGT/wW',
        (select id from authority where authority = 'ROLE_USER'));