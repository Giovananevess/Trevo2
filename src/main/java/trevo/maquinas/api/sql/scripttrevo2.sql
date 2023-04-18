create database trevo2;

    create table tb_product (
        id uuid not null,
        category smallint,
        date varchar(255),
        description varchar(255) not null,
        name varchar(255) not null,
        price float(53) not null,
        status smallint,
        primary key (id)
    );

    create table tb_user (
       id bigint not null,
        date varchar(255),
        login varchar(255) not null,
        name varchar(255) not null,
        password varchar(255) not null,
        profile varchar(255),
        primary key (id)
    );

    alter table if exists tb_product
       add constraint UK_bogsiyr1vtndt8r0u5b5iwo7o unique (description);

    alter table if exists tb_product
       add constraint UK_lovy3681ry0dl5ox28r6679x6 unique (name);

    alter table if exists tb_product
       add constraint UK_8bnnj1b72jtahuhqsouatgsum unique (price);

    alter table if exists tb_user
       add constraint UK_qht682qvopcx5f41dc2rbs5jf unique (login);

    alter table if exists tb_user
       add constraint UK_jus3xa0l3009mkpbt9i5ilxx3 unique (name);

    alter table if exists tb_user
       add constraint UK_tfvyu71xyt1oecea6jguuuts unique (password);