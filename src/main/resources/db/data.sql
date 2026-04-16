insert into scheduler.tasks (id, task_type, message, created_at, execution_date, execution_time) values
(
'ebc18ab5-e6d4-4b85-b40c-e575615c3225',
'telegram',
'Заменить фильтр воды',
'2026-04-24 12:00:00',
current_date,
'17:00:00'
),
(
 '0f6d0113-3365-442b-9d78-3a1fea559e2d',
 'telegram',
 'Заменить воздушный фильтр',
 '2026-04-24 12:01:00',
 current_date,
 '15:00:00'
);