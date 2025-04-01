# Filmu_kolekcija

1. obkjetks


Filma (Movie)
Šis būs galvenais objekts, kas satur visu informāciju par katru filmu.

Atribūti:

nosaukums (String) – Filmas nosaukums.

žanrs (String) – Filmas žanrs (komēdija, drāma, trilleris utt.).

ilgums (int) – Filmas ilgums minūtēs.

izlaidumaGads (int) – Filmas izlaiduma gads.

vērtējums (double) – Filmas vērtējums (piemēram, IMDb vērtējums).

2. objekts 

Seriāls (TVShow)
Šis objekts būs līdzīgs Filma objektam, bet ar īpašībām, kas raksturīgas seriāliem.

Atribūti:

nosaukums (String) – Seriāla nosaukums.

režisors (String) – Seriāla režisors.

žanrs (String) – Seriāla žanrs (drāma, komēdija, trilleris utt.).

aktieri (String[]) – Aktieri, kas piedalās seriālā.

izlaidumaGads (int) – Seriāla izlaiduma gads.

sezonasSkaits (int) – Sezonu skaits seriālā.

sērijasSkaits (int) – Kopējais sēriju skaits visās sezonās.

vērtējums (double) – Seriāla vērtējums (piemēram, IMDb vērtējums).

apraksts (String) – Īss seriāla apraksts.






3. objekts

Filmu kolekcija (MovieCollection)
Šis objekts glabā visu filmu kolekciju. Tas būs klase, kas darbojas kā konteineris, kurā varēs pievienot, dzēst un meklēt filmas.

Atribūti:

filmas (Filma[]) – Masīvs vai saraksts, kas satur visas filmas kolekcijā.

Metodes:

pievienotFilmu(Filma filma) – Pievienot filmu kolekcijai.

dzēstFilmu(String nosaukums) – Dzēst filmu pēc nosaukuma.

meklētFilmu(String nosaukums) – Meklēt filmu pēc nosaukuma.

parādītFilmas() – Parādīt visas filmas kolekcijā.

filtrētFilmasPēcŽanra(String žanrs) – Filtrēt filmas pēc žanra.


4. objekts 

Lietotājs (User)
glabātu informāciju par katru lietotāju, piemēram, viņu izvēlētās filmas  utt.

Atribūti:

vārds (String) – Lietotāja vārds.

email (String) – Lietotāja e-pasts.

izvēlētāsFilmas (Filma[]) – Saraksts ar filmām, ko lietotājs ir izvēlējies, piemēram, kā "vēlos redzēt" vai "redzētas".

Metodes:

pievienotIzvēlētoFilmu(Filma filma) – Pievieno filmu lietotāja izvēlētajām filmām.

skaitītIzvēlētāsFilmas() – Atgriež izvēlēto filmu skaitu.

parādītIzvēlētāsFilmas() – Parāda visas lietotāja izvēlētās filmas.