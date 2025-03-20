# **SurvivalStats Plugin**

De **SurvivalStats** plugin voor Spigot 1.21.4 houdt de overlevingsstatistieken bij van spelers op je server. Het volgt het aantal overlevingsdagen en sterfgevallen van spelers en slaat deze gegevens op voor toekomstig gebruik.

## Functies
- **Overlevingsstatistieken:** Bekijk het aantal overlevingsdagen en sterfgevallen van jezelf of andere spelers via het `/survivalstats` commando.
- **Automatische updates:** De statistieken worden elke minuut bijgewerkt.
- **Player Deaths:** Bij overlijden worden de overlevingsdagen weergegeven en het sterfte-teller verhoogd.
- **Persistente gegevens:** Spelerstatistieken worden opgeslagen in een YAML-bestand en blijven behouden tussen server herstarts.

## Installatie
1. Download de plugin en plaats deze in de `plugins` map van je Spigot-server.
2. Herstart de server.
3. De plugin is nu actief en klaar voor gebruik!

## Commando's
- `/survivalstats` - Toont je eigen overlevingsstatistieken.
- `/survivalstats <speler>` - Toont de overlevingsstatistieken van een andere speler (indien online).

## Bestanden
- De spelerstatistieken worden opgeslagen in het bestand `player_data.yml`.

## Licentie
Dit project is gelicenseerd onder de MIT-licentie - zie [LICENSE](LICENSE) voor meer informatie.
