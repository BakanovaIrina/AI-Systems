% Факты с одним аргументом

% Куклы (4)
doll(barbie).
doll(teresa).
doll(stacy).
doll(kim).

% Наряды для кукол (10)
outfit(big_dress).
outfit(office_set).
outfit(wedding_dress).
outfit(elegant_dress).
outfit(doctors_coat).
outfit(swimsuit).
outfit(sparkly_dress).
outfit(stewardess_costume).
outfit(tennis_suit).

% Стили для одежды (3)
styles(official_style).
styles(work_style).
styles(sport_style).

% Цвета для одежды (5)
colors(white).
colors(black).
colors(pink).
colors(blue).
colors(green).

% События для кукол (2)
event(wedding).
event(olimpiada).
event(works_festival).

% Факты с двумя аргументами

% Любимые цвета кукол
favorite_color(barbie, pink).
favorite_color(teresa, white).
favorite_color(stacy, blue).
favorite_color(kim, black).


% Цвета конкретной одежды (10)
color(swimsuit, pink).
color(elegant_dress, pink).

color(wedding_dress, white).
color(doctors_coat, white).
color(tennis_suit, white).

color(office_set, black).

color(sparkly_dress, blue).
color(big_dress, blue).

color(stewardess_costume, green).


% Стили конкретной одежды (10)
style(big_dress, official_style).
style(wedding_dress, official_style).
style(sparkly_dress, official_style).

style(elegant_dress, work_style).
style(office_set, work_style).
style(doctors_coat, work_style).
style(stewardess_costume, work_style).

style(swimsuit, sport_style).
style(tennis_suit, sport_style).

% Мероприятия для кукол со стилями
event_style(wedding, official_style).
event_style(olimpiada, sport_style).
event_style(works_festival, work_style).

% Ношение нарядов
wearing(barbie, big_dress).
wearing(teresa, sparkly_dress).
wearing(stacy, elegant_dress).
wearing(kim, big_dress).

% Правила

% Правило 1: Подходит ли к мероприятию этот наряд
is_outfit_for_event(Outfit, Event) :- 
	outfit(Outfit), 
	event_style(Event, Style), 
	style(Outfit, Style).
	
% Правило 2: Проверка совпадения нарядов у двух кукол
outfits_match(Doll1, Doll2) :- 
	doll(Doll1), 
	doll(Doll2), 
	outfit(Outfit), 
	Doll1 \= Doll2, 
	wearing(Doll1, Outfit), 
	wearing(Doll2, Outfit).
	
% Правило 3: Проверка совпадения цветов разных нарядов у двух кукол
outfits_color_match(Doll1, Doll2) :- 
	doll(Doll1), 
	doll(Doll2), 
	wearing(Doll1, Outfit1), 
	wearing(Doll2, Outfit2), 
	color(Outfit1, Color), 
	color(Outfit2, Color), 
	Doll1 \= Doll2.

% Правило 4: Определение, что наряд подходит для кукол с их предпочитаемыми цветами
is_outfit_with_favorite_color(Outfit, Doll) :- 
	outfit(Outfit), 
	doll(Doll),
	favorite_color(Doll, Color), 
	color(Outfit, Color).
	
% Правило 5: Подходит ли наряд данной куклы для данного мероприятия по стилю
outfit_fits_event_style(Doll, Event) :- 
	doll(Doll), 
	event(Event),
	event_style(Event, Style), 
	wearing(Doll, Outfit), 
	style(Outfit, Style).