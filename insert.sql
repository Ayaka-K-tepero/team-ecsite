use plumdb;

INSERT INTO mst_user(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)VALUES
('yaoyatarou@aaa.bbb', 'yt123', '八百屋', '太郎', 'やおや', 'たろう',1); 


INSERT INTO mst_category(category_name, category_description)VALUES
('肉', 'とりぶたぎゅう！'),
('魚', '王道のアジマグロ'),
('青果', 'ダイエットの味方キャベツとりんご');


INSERT INTO mst_product(product_name, product_name_kana, product_description, category_id, price, image_full_path, release_date, release_company)VALUES
('鶏肉', 'とりにく', '日本で一番食べられている肉', 1, 250, '/img/トリ.jpg', '2023/1/4', 'ジョークマート') ,
('豚肉', 'ぶたにく', '疲労回復に効くビタミンB1が豊富', 1, 580, '/img/ブタ.jpg', '2023/1/4', 'ジョークマート') ,
('牛肉', 'ぎゅうにく', '美味しさ見分けポイントは紅色の強さ', 1, 1500, '/img/ギュウ.jpg', '2023/1/4', 'ジョークマート') ,
('鯵', 'あじ', '5~7月が旬の魚', 2, 500, '/img/アジ.jpg', '2023/1/4', 'ジョークマート') ,
('鮪', 'まぐろ', '世界の消費量半数は日本', 2, 1000, '/img/マグロ.jpg', '2023/1/4', 'ジョークマート') ,
('キャベツ', 'きゃべつ', '胃の粘膜回復に効果的', 3, 200, '/img/キャベツ.jpg', '2023/1/4', 'ジョークマート') ,
('林檎', 'りんご', '1日1個の林檎は医者を遠ざける', 3, 100, '/img/リンゴ.jpg', '2023/1/4', 'ジョークマート') ;