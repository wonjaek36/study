/* Article Table */
INSERT INTO article(title, content) VALUES ('title1', 'content1');
INSERT INTO article(title, content) VALUES ('title2', 'content2');
INSERT INTO article(title, content) VALUES ('title3', 'content3');
INSERT INTO article(title, content) VALUES ('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES ('당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(title, content) VALUES ('당신의 취미는?', '댓글 고고고');

/* Comment Table */
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Choi', '쇼생크 탈출');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Choi', '초밥');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Choi', '독서');

/* Member Table */
INSERT INTO member(username, password) VALUES ('cat', 'dog');
INSERT INTO member(username, password) VALUES ('duck', 'goose');
INSERT INTO membeR(username, password) VALUES ('tiger', 'lion');

/* Coffee Table */
INSERT INTO coffee(name, price) VALUES ('americano', '4500');
INSERT INTO coffee(name, price) VALUES ('latte', '5000');
INSERT INTO coffee(name, price) VALUES ('mocha', '5500');