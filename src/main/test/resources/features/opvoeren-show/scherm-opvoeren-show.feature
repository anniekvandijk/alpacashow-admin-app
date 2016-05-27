# language:nl

Functionaliteit: Als medewerker van de administratie wil ik de gegevens van een show kunnen invoeren op een scherm, zodat deze gebruikt kunnen worden voor de show administratie.

Scenario: Navigeren naar scherm voor opvoeren nieuwe show
Stel ik ben als administratiemedewerker op het scherm 'showgegevens' # waar kom ik vandaan? > story, # autorisatie? > story
Als ik op de knop 'nieuwe show opvoeren' klik
Dan verwacht ik dat ik in het scherm 'opvoeren showgegevens' kom

Scenario: invoer gegevens
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Dan verwacht ik dat ik de volgende gegevens kan opvoeren
 | Naam show |
 | Datum show |
 | Sluitingsdatum aanmeldingen |
 | Plaats show |
 | Jury |

Scenario: melding bij opslaan correcte gegevens
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Als ik alle showgegevens correct invoer
En ik druk op 'opslaan'
Dan verwacht ik dat ik terug ga naar het scherm 'showgegevens'
En verwacht ik op het scherm 'showgegevens' een melding 'showgegevens opgeslagen'

Scenario: melding bij annuleren
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Als ik alle showgegevens correct invoer
En ik druk op 'annuleren'
Dan verwacht ik de melding 'weet u zeker dat u wilt annuleren - ja / nee'

Scenario: annuleren, nee
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Als ik alle showgegevens correct invoer
En ik druk op 'annuleren'
En ik druk bij de melding 'weet u zeker dat u wilt annuleren' op nee
Dan verwacht ik dat er geen wijzigingen op het scherm zijn

Scenario: annuleren, ja
Stel ik ben als administratiemedewerker op het scherm 'opvoeren showgegevens'
Als ik alle showgegevens correct invoer
En ik druk op 'annuleren'
En ik druk bij de melding 'weet u zeker dat u wilt annuleren' op ja
Dan verwacht ik dat ik terug ga naar het scherm 'showgegevens'
En verwacht ik op het scherm 'showgegevens' een melding 'showgegevens opvoeren geannuleerd'
