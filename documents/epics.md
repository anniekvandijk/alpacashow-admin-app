# Epics

**[Opvoeren show](../alpacashow-admin-it/src/main/test/resources/features/opvoeren-show.feature)**

De administratie kan een show en showdetails opvoeren. Deze gegevens kunnen geraadpleegd en gewijzigd worden. Hiervoor zijn schermen beschikbaar. Bij de opvoer worden er controles uitgevoerd op de juistheid van de invoer.

**[Deelnemer kan online dieren inschrijven](../alpacashow-admin-it/src/main/test/resources/features/deelnemer-dieren-inschrijven.feature)**

Een deelnemer kan zich inschrijven voor een show. Hij kan een minimum en maximum aantal dieren opvoeren, wijzigen en verwijderen. Op de inschrijvingen worden validaties uitgevoerd. Welke dieren hij heeft ingeschreven kan hij raadplegen. De administratie kan deze deelnemer en dieren ook raadplegen, wijzigen en verwijderen. Hiervoor zijn schermen beschikbaar.

> doel is een applicatie voor de administratie, direct linken met inschrijvingen is een wens. Lagere prio.

**[Administratie kan een lijst van deelnemers en dieren inlezen](../alpacashow-admin-it/src/main/test/resources/features/administratie-lijst-deelnemers-dieren-inlezen.feature)**

De administratie kan een lijst met deelnemers en dieren inlezen. Deze wordt gevalideerd en opgeslagen. De lijst met deelnemers en dieren kunnen geraadpleegd, gewijzigd en verwijderd worden. Hiervoor zijn schermen beschikbaar.

**[Automatische klassebepaling dieren](../alpacashow-admin-it/src/main/test/resources/features/automatische-klassebepaling-dieren.feature)**

Als er via online inschrijving of inlezen van een lijst dieren worden aangemeld, dan worden de klasse van de dieren automatisch bepaald aan de hand van de soort, de leeftijdsgroep, het geslacht en de kleur. De klasse moet altijd kloppen, dus bij elke wijziging van de kenmerken moet de klasse herbepaald worden. De klasse hoort bij een individueel dier en wordt daarom bij de gegevens van een dier opgeslagen en getoond.

**[Handmatig showvolgorde bepalen](../alpacashow-admin-it/src/main/test/resources/features/handmatig-showvolgorde-bepalen.feature)**

De administratie kan de volgorde van de showklassen handmatig bepalen, zodat dieren in de juiste volgorde in de show worden gepresenteerd. Hiervoor is een scherm beschikbaar.

**[Startnummers toekennen](../alpacashow-admin-it/src/main/test/resources/features/startnummers-toekennen.feature)**

Na sluiting van inschrijving worden aan de hand van de klasse/show-volgorde startnummers toegekend aan de dieren. Deze mogen na toekenning niet meer gewijzigd worden. 

**[Automatische indeling eerste ronde](../alpacashow-admin-it/src/main/test/resources/features/automatische-indeling-eerste-ronde.feature)**

Aan de hand van de klasse/show-volgorde worden er automatisch ringen bepaald voor de eerste ronde. Aan de ringen wordt een minimum en maximum aantal dieren toegekend. Zijn er minder dieren in de klasse dan het minimum, dan worden er 2 of meer ringen samengevoegd tot het maximum is bereikt. Zijn er meer dieren, dan wordt een ring gesplits. 

**[Handmatig bepalen prijzen en vervolgronden](../alpacashow-admin-it/src/main/test/resources/features/handmatig-bepalen-prijzen-vervolgronden.feature)**

Elke ronde kunnen er prijzen worden gewonnen. Er kunnen 1 of meer vervolgronden zijn na ronde 1. Hoeveel ronden dat zijn en welke prijzen door mogen naar de volgende ronde moet handmatig aangegeven kunnen worden. 

**[Automatisch aanmaken vervolgronden]../alpacashow-admin-it/src/main/test/resources/features/automatisch-aanmaken-vervolgronden.feature)**

Aan de hand van de bepaling prijzen en vervolgronden moet er tijdens de show automatisch worden bepaald wie er door gaat naar de volgende ronde. Dit moet handmatig aangepast kunnen worden.

**[Handmatig wijzigen dieren en ringen](../alpacashow-admin-it/src/main/test/resources/features/ohandmatig-wijzigen-dieren-ringen.feature)**

De administratie moet voor en tijdens de show dieren en ringen handmatig kunnen wijzigen. Ook kan er aangegeven worden dat een dier niet aanwezig is of een dier uitgesloten is van deelname. Als een dier door wijziging in een andere klasse terecht komt, dan moet dit dier verplaatst kunnen worden naar een andere ring of uitgesloten kunnen worden. Deze dieren moeten duidelijk zichtbaar zijn ( twijfelpunt, dit laatste zou ook automatisch kunnen, maar dat moet wel als aparte epic worden opgenomen dan).

> todo: deze epic is niet ok, herzien en mogelijk splitsen in meerdere delen. Hier mist ook nog het deel dat een ronde die is geweest niet meer kan wijzigen.

**[Printen](../alpacashow-admin-it/src/main/test/resources/features/printen.feature)**

De administratie moet ringlijsten en certificaten kunnen printen tijdens de show.

**[Presentatie](../alpacashow-admin-it/src/main/test/resources/features/presentatie.feature)**

Er moeten schermen beschikbaar zijn voor de deelnemers en administratie die het mogelijk maken om het overzicht te hebben over showgegevens, de deelnemers, dieren, klasse volgorde, ringen, vervolgringen, prijzen en output. Tevens moet het makkelijk zijn om zaken aan te passen. > kan mogelijk voor het grootste deel bij andere epics worden uitgewerkt.

**Autorisatie**

Nog uitwerken...

**Meerdere shows**

Het moet mogelijk zijn om meerdere shows te kunnen opvoeren. Welke show actief is of niet kan aangegeven worden. Inschrijving van deelnemers, dieren, showvolgorde, ringen, prijzen en ronden kunnen per show worden aangegeven. 

