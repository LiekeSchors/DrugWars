NICHT AKTUELL!

Regeln für das Spiel:
V Am Anfang hat der Spieler 2.000$ an cash und 0$ an Schulden
V Drogen im Originalspiel: Cocaine, Heroin, Acid, Grass, Speed, Ludes. Diese kann der Spieler in einer Stadt kaufen und
    verkaufen.

    - Wurde als enum realisiert.

- Die Preise der Drogen ($) im Originalspiel bewegen sich in folgenden Wertebereichen: Cocaine = 15.000-30.000,
    Heroin = 5.000-14.000, Acid = 1.000-4.500, Grass = 300-900, Speed = 70-250, Ludes = 10-60.
    Die Preise schwanken zufällig, und die Preise der Drogen können sinken/steigen, wenn der Spieler reist.

V Der Spieler kann maximal 100 Produkte tragen (alle Produkte sind gleich schwer).

V Es gibt folgende Stadtteile, zu denen der Spieler reisen kann: Bronx, Ghetto, Central Park, Manhattan, Coney Island,
    Brooklyn.

    Nur für Bronx eine eigene Klasse. Die Distanz zwischen Städten wird in City festgelegt.

- Ein Spieler kann nicht zu der Stadt reisen, in der er sich aktuell befindet.

- Eine Reise dauert einen Tag. Bei der Reise können zufällig Ereignisse passieren, ein paar Ideen:
    - Das Geld kann dem Spieler von einem Fremden geklaut werden.
    - Bei einer Reise kann der Spieler hin und wieder Drogen finden.
    - Je nach Distanz zur ausgewählten Stadt kostet die Reise mehr oder weniger Geld.

    Event ist eine abstrakte Klasse und enthält eine abstrakte Methode, die je nach Event unterschiedlich implementiert
    werden wird,


- In der Bronx - und nur dort - gibt es:
    - eine Bank zum Einzahlen/Abheben
    - Ein Versteck zum Sichern der Drogen
    - einen Kredithai für den Geldverleih
        - Der Spieler kann sich vom Kredithai nur Geld leihen, wenn er keine Schulden hat.
        - Schuldzinsen betragen 10% pro Tag
        - Sparzinsen brauchen 5,5% pro Tag

V Nach 30 Tagen ist das Spiel zu Ende. Dann werden Gewinn und Schulden verrechnet.

- Ergänzen eigener Regeln
- Textoberfläche realisieren: https://github.com/mabe02/lanterna
