# language:nl

Functionaliteit: De administratie kan een lijst met deelnemers en dieren inlezen.
  Deze wordt gevalideerd en opgeslagen.
  De lijst met deelnemers en dieren kunnen geraadpleegd,
  gewijzigd en verwijderd worden. Hiervoor zijn schermen beschikbaar.

      # TODO gegevens specificeren

  # gegevens worden niet ingelezen:
  # Ingeleze document is geen csv
  # bestand is te groot
  # kolommen komen niet overeen met data
  # gegevens worden wel ingelezen, maar bevatten foute data:
  # verplichte records bevatten lege data
  # records kunnen niet gematched worden
  # geboortedatum, scheerdatum, showdatum check
  # gegevens kunnen altijd verbeterd worden, maar indien fout worden ze niet opgeslagen

  Scenario: Inlezen juiste csv
    Stel ik ben als administratiemedewerker ingelogd
    Als ik een juiste csv "naam csv" inlees
    Dan verwacht ik dat de ingelezen dieren in tabelvorm getoond worden op het scherm
    Als ik op akkoord druk
    Dan worden de juiste gegevens opgelagen

  Scenario: Inlezen csv met foute data
    Stel ik ben als administratiemedewerker ingelogd
    Als ik een foute csv "naam csv" inlees
    Dan verwacht ik dat de ingelezen dieren in tabelvorm getoond worden op het scherm
    En vwerwacht ik dat foutieve velden duidelijk worden weergegeven
    Als ik op akkoord druk
    Dan worden de juiste gegevens opgelagen
    En worden de foute gegevens niet opgeslagen

  Scenario: Verbeteren record met foute data
    Stel ik ben als administratiemedewerker ingelogd
    Als ik een foute csv "naam csv" inlees
    En ik verbeter de fouten
    Als ik op akkoord druk
    Dan worden de juiste gegevens opgelagen
    En worden de verbeterde gegevens opgelagen
    En worden de foute gegevens niet opgeslagen