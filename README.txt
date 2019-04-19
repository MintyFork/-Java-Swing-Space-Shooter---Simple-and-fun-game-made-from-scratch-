Space Shooter - Kamil Stanisawski

W grze lecimy statkiem i próbujemy przedosta si do kolejnego poziomu(Stage). By tego dokona niszczymy wrogie statki obcych. Gdy zniszczymy wszystkie przechodzimy na kolejny poziom, w którym czeka na nas wiksze wyzwanie. Dotknicie pocisków przeciwników koczy gr.

Rekomendowana rozdzielczo, 1920x1080.

Cechy gry:

Zadane:
1.
- Grafika, muzyka i efekty dwiekowe s umieszczone w pliku JAR.
- Gra uruchamia si z pliku JAR.
2.
- W grze wikszo obiektów jest animowane, rednio zwieraj po 12 framów. 
Lista obiektów animowanych:	
	- To.
	- Statek.
	- Pocisk gracza.
	- Statek obcych 1.
	- Statek obcych 2.
	- Statek obcych 3.
	- Statek obcych 4.
	- Statek obcych 5.
	- Pocisk obcych.
Lista obiektów nie animowanych:
	- GameOver
	- Credits
	- Stage 1
	- Stage 2
	- Stage 3
	- Stage 4
	- Stage 5
- Metody rysowania grafiki to wycznie obrazy.
3. 
- Animacja z uyciem Timer Swing jest wykorzystana.
- Zmiana klatek animacji jest. Zwaszcza wida j w reagowaniu statku na zmian kierunku lotu gracza.
4.
- Interakcja z uytkownikiem jest wykorzystywana wycznie za pomoc klawiatury.
- Muzyka w tle jest. (Stworzona przezemnie w programie Boscaceoil.) Jak równierz s efekty dwikowe. (Stworzone w programie Bfxr.) S one w pliku JAR. 
Lista efektów dwiekowych:
	- Theme (Podkad muzyczny. Wykorzystywany podczas gry waciwej.(Gracz jest ywy.)
	- Kontakt (Wykorzystywany na pocztku nowego poziomu(stage))
	- Pocisk (Wykorzystywany podczas strzau gracza)
	- End (Wykorzystywany podczas ekranu GameOver)
5.
- Gra ma swój pocztek oraz koniec.
- Gra posiada hitboxy, kady jest prostoktem. Kolizj s sprawdzane w tle i reaguj gdy dany obiekt wpada w hitbox(pole) innego obiektu. 
Kolizje wystpujace w grze:
	- [Gracz] wpada w pole [Wrogi Pocisk] - Gra kasuje wszystkie obiekty, wywietla obiekt [GameOver] i uruchamia [End.wav]. Nastpnie po trzech sekundach, wywietla obiekt [Credits]. Po sekundzie wyancza gr.
	- [Pocisk gracza] wpada w pole [Statek obcych X] - [Statek obcych X] zostaje usunity z listy obiektów.

Wasne:
- Proceduralnie generowane fale wrogów. (Symetria wzgldem osi y) 
- Gra jest stworzona w do ciekawy sposób gdy bardzo zaleao mi na grafice w stylu PixelArt. Dziki temu gra zajmowaa by mao miejsca na dysku, jak i równie bya by atwa do tworzenia.(Od strony grafiki) Dlatego zdecydowaem by oryginalna rozdzielczo gry wynosia 192x108, czyli dziesie razy mniej ni rozdzielczo na któr chc tworzy t gr. Dao to bardzo fajny efekt graficzny z zachowaniem powyszych zalet, ale jak to dziaa? Gra sprawdza rozdzielczo ekranu gracza i jeli wynosi ona 1920x1080, gra wywiatlana jest na penym ekranie a atrybut [Scale] wynosi [10]. Natomiast jeli rozdzielczo jest inna, wywiatla gr w oknie i nadaje jej scale równy liczbie cakowitej z dzielenia szeroko rozdzielczoci(Ekranu) gracza przez 192. Co pozwala na wygodne granie w kadej rozdzielczoci, bez problemu za duego okna.
Uyem technologii Java Swing. Wypeniem wszystkie zadane zagadnienia. W zakresie programowania wykorzystaem wycznie wiedz nabyt w czasie zaje. Ten projekt w duym stopniu rowin moje umiejtnoci programowania w Java Swing, jak i ogólnie.
- Mona [Odlecie] statkiem poza ekran, jest to celowy zabieg. Pozwala pokaza graczowi e uciekajc od konfrontacji moe przeyjemy, ale nie przejdziemy na kolejny poziom. Wic po co gra? Nastpnym pytaniem moe by czemu jednym pociskiem mona zniszczy kilku wrogów. Odpowied to: Gra trwa by zbyt dugo.

Czas wykonania:
Grafika - 3h
Muzyka & Efekty Dwikowe - 2h
Programowanie - 6h
Debugowanie - 3h
