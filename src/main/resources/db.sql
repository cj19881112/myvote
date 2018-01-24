CREATE TABLE "t_craft" (
  "craft_id"  INT(11) PRIMARY KEY AUTO_INCREMENT,
  "vote_id"  int(11),
  "sence_id"  int(11),
  "name"  varchar(256),
  "img"  varchar(256)
);

CREATE TABLE "t_sence" (
  "sence_id"  INT(11) PRIMARY KEY AUTO_INCREMENT,
  "vote_id"  int(11),
  "sence_name"  varchar(256),
  "voting"  char(1)
);

CREATE TABLE "t_show" (
  "vote_id"  integer PRIMARY KEY AUTO_INCREMENT,
  "current_sence"  int(11),
  "vote_name"  varchar(256)
);

CREATE TABLE "t_vote" (
  "user_vote_id" INTEGER PRIMARY KEY AUTO_INCREMENT,
  "craft_id"     INT(11),
  "user_id"      VARCHAR(256),
  "vote_type"    INT(11)
);


