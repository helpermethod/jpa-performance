CREATE TABLE comment(
    id uuid primary key,
    post_id uuid references post(id),
    content text
);