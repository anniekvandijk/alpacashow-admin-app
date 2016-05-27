# language:nl

Functionaliteit: medewerker van de administratie wil ik dat de ingevoerde gegevens gecontroleerd worden op juistheid, 
zodat er geen foute gegevens worden berekend en alle nodige gegevens aanwezig zijn.

Abstract scenario: validatie op verplicht veld
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Als ik in het veld '<Veld>' geen waarde invoer
Dan verwacht ik de melding 'Het veld '<Veld>' is verplicht
En is het niet mogelijk om op de 'opslaan' knop te drukken

Abstract scenario: validatie op onjuiste gegevens
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Als ik in het veld '<Veld>' een onjuiste waarde invoer
Dan verwacht ik de melding 'De invoer in het veld '<Veld>' is niet toegestaan
En is het niet mogelijk om op de 'opslaan' knop te drukken

# todo: veldlengte
# todo: automatische correctie datum velden, datumkiezer? > toevoegen aan story?
# todo: onjuiste invoer kan (grotendeels) naar unittesten


