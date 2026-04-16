drop table scheduler.tasks;
drop schema scheduler;

create schema scheduler;

create table scheduler.tasks (
    id uuid not null,
    task_type varchar(255) not null,
    message varchar(255) not null,
    created_at timestamp(6) not null,
    execution_date date not null,
    execution_time time not null,
    status enum ('PENDING', 'PROCESSING', 'COMPLETED', 'FAILED') default('PENDING'),
    constraint pk_tasks_id primary key (id)
);
