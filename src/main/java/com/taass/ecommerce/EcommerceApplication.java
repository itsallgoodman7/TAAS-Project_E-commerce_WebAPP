package com.taass.ecommerce;

import com.taass.ecommerce.model.MusicDevice;
import com.taass.ecommerce.model.MusicDeviceCategories;
import com.taass.ecommerce.service.MusicDeviceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(MusicDeviceService musicDeviceService) {
        return args -> {
            musicDeviceService.save(new MusicDevice(1L, "Airpods Max", 449.99, MusicDeviceCategories.Consumer,  "https://m.media-amazon.com/images/I/81jkMpNHVsL._AC_SL1500_.jpg", "Driver dinamico progettato da Apple per un suono ad alta fedeltà\n" +
                    "Cancellazione attiva del rumore per bloccare i rumori esterni e immergerti totalmente nella musica\n" +
                    "Modalità Trasparenza per ascoltare il mondo intorno a te\n" +
                    "Audio spaziale con rilevamento dinamico della posizione della testa, per un effetto surround da cinema\n" +
                    "Audio computazionale che combina un design acustico unico con il chip H1 e il software Apple per creare un’esperienza di ascolto rivoluzionaria"));
            musicDeviceService.save(new MusicDevice(2L, "Sony WH-1000XM5", 419.99, MusicDeviceCategories.Consumer, "https://m.media-amazon.com/images/I/61-rQj6wZnL._AC_SL1500_.jpg","Il nuovo Processore Integrato V1 massimizza il potenziale del Processore di Eliminazione del Rumore HD QN1: la più grande innovazione nella nostra già leader tecnologia di eliminazione del rumore.\n" +
                    "Progettate con precisione per offrire un'eccezionale qualità di ascolto, anche in chiamata grazie alla tecnologia di rilevamento della voce e alla nuova struttura di riduzione del rumore del vento.\n" +
                    "L'Adaptive Sound Control regola automaticamente le impostazioni audio in base all'ambiente e all'attività e la funzione Speak-to-Chat mette automaticamente in pausa la musica quando vuoi parlare.\n" +
                    "Queste cuffie possono essere accoppiate con due dispositivi in contemporanea. Con Fast Pair puoi localizzare le WH-1000XM5 se non riesci a trovarle e Swift Pair semplifica il pairing al tuo PC/tablet.\n" +
                    "Con una durata della batteria fino a 30 ore, avrai abbastanza energia, anche per lunghi viaggi! Una custodia pieghevole è inclusa con queste cuffie Sony per conservarle e trasportarle comodamente."));
            musicDeviceService.save(new MusicDevice(3L, "Apple Airpods 3^a generazione", 167.99, MusicDeviceCategories.Consumer,"https://m.media-amazon.com/images/I/61Z5J-fq7KL._AC_SL1500_.jpg","\n" +
                    "Audio spaziale con rilevamento dinamico della posizione della testa, per un suono tridimensionale\n" +
                    "EQ adattiva: calibra la musica in base alla forma del tuo orecchio\n" +
                    "Nuovo design affusolato\n" +
                    "Sensore di pressione per controllare facilmente la musica, rispondere alle chiamate e riagganciare\n" +
                    "Resistenza a sudore e acqua\n" +
                    "Fino a 6 ore di ascolto con una sola carica\n" +
                    "Fino a 30 ore totali di ascolto con la custodia di ricarica MagSafe\n" +
                    "Attivazione rapida di Siri con il comando “Ehi Siri”\n" +
                    "Setup semplicissimo: gli auricolari capiscono quando li indossi e passano automaticamente da un dispositivo all’altro per un’esperienza magica\n" +
                    "Puoi condividere facilmente l’audio del tuo iPhone, iPad, iPod touch o dell’Apple TV fra due paia di AirPods"));
            musicDeviceService.save(new MusicDevice(4L, "Apple AirPods Pro", 188.99, MusicDeviceCategories.Consumer,"https://m.media-amazon.com/images/I/71bhWgQK-cL._AC_SL1500_.jpg", "Cancellazione attiva del rumore per bloccare i rumori esterni e immergerti completamente nella musica\n" +
                    "Modalità Trasparenza per sentire il mondo intorno a te\n" +
                    "Audio spaziale con rilevamento dinamico della posizione della testa, per un suono tridimensionale\n" +
                    "EQ adattiva: calibra la musica in base alla forma del tuo orecchio\n" +
                    "Cuscinetti affusolati, realizzati in morbido silicone e disponibili in tre taglie per un comfort su misura\n" +
                    "Sensore di pressione per controllare facilmente la musica, rispondere alle chiamate e riagganciare\n" +
                    "Resistenza a sudore e acqua\n" +
                    "Più di 24 ore totali di ascolto con la custodia di ricarica MagSafe\n" +
                    "Attivazione rapida di Siri con il comando “Ehi Siri”\n" +
                    "Setup semplicissimo: gli auricolari capiscono quando li indossi e passano automaticamente da un dispositivo all’altro per un’esperienza magica"));
            musicDeviceService.save(new MusicDevice(5L, "Giradischi VOKSUN Bluetooth", 79.99, MusicDeviceCategories.Consumer,"https://m.media-amazon.com/images/I/71RPYGTeqNL._AC_SL1500_.jpg", "Design classico: il giradischi è una perfetta combinazione di elementi di tendenza e stile retrò con classiche serie di colori. Pelle PVC, viti in metallo in stile retrò, bottone galvanico, superficie classica in pelle che mostra il buon gusto e diventa un punto centrale nella vostra casa, festa o festa di famiglia. Il design della borsa facilita lo spostamento.\n" +
                    "Piatto girevole a 3 velocità: supporta 3 grandi dischi in vinile da 7,10,12 pollici e 3 velocità di riproduzione di 33, 45, 78 RMP. Godetevi il gioco autonomo costante e sicuro.\n" +
                    "Bluetooth 5.0: con Bluetooth 5.0 puoi riprodurre musica dal tuo dispositivo Android OS iOS o altro smartphone, il dispositivo è perfettamente adattato alle tue diverse esigenze. Questo prodotto può essere utilizzato solo come ricevitore Bluetooth. Es kann keine Verbindung zu Ihrem Bluetooth-Lautsprecher hergestellt werden.\n" +
                    "Ingressi e uscite multiple: 2 altoparlanti stereo dinamici a tutto raggio integrati garantiscono una voce ricca ed eccellente. 3,5 mm, AUX, USB, ingresso per scheda SD e registrazione in vinile per MP3 garantiscono una sensazione antica. È possibile trasmettere iTunes tramite il giradischi tramite la connessione Bluetooth. Tramite il connettore RCA sul retro del giradischi è possibile collegarlo all'amplificatore esterno.\n" +
                    "Sistema stereo: il lettore dispone di due altoparlanti integrati. Per compensare l'effetto di risonanza e bassi profondi, abbiamo limitato la potenza a 5 Watt, ognuno dei quali è adatto per l'uso quotidiano. Se si dispone di un eccellente sistema audio, è possibile collegarlo a questo lettore tramite la porta RCA o AUX, e godere di un effetto surround"));
            musicDeviceService.save(new MusicDevice(6L, "Yamaha CGS102A 1/2 Size Classical Guitar", 301.32, MusicDeviceCategories.Acoustic, "https://m.media-amazon.com/images/I/31p69xAiD5L._AC_.jpg", "Top in abete rosso\n" +
                    "Meranti schiena e lati\n" +
                    "Collo Nato\n" +
                    "Sonokeling Tastiera\n" +
                    "Meranti schiena e fianchi collo Nato"));
            musicDeviceService.save(new MusicDevice(7L, "Forenza F1151A Violino Serie Uno, Misura 4/4", 59.99, MusicDeviceCategories.Acoustic,"https://m.media-amazon.com/images/I/813oDnJEgeL._AC_SL1500_.jpg", "Violino misura normale ideale per studenti\n" +
                    "Con ponticello e allestimento completo pronto per suonare\n" +
                    "Provvisto di piroli e cordiera con macchinette per l'accordatura fine\n" +
                    "Include archetto in legno e blocchetto di colofonia\n" +
                    "Leggera custodia con cerniera, manico e spallacci"));
            musicDeviceService.save(new MusicDevice(8L, "Kawai ES 520 W · Pianoforte da palco", 1242.00, MusicDeviceCategories.Acoustic,"https://m.media-amazon.com/images/I/61oJM1hy+ZL._AC_SL1200_.jpg", "Numero tasti: 88\n" +
                    "Generazione del suono: Progressive Harmonic Imaging Sound Technologie mit 88 Tasten Sampling\n" +
                    "Polifonia: 192 voices\n" +
                    "USB/MIDI: MIDI (in/out), USB to Host, USB to Device\n" +
                    "Potenza (watt rms): 2 x 20 W"));
            musicDeviceService.save(new MusicDevice(9L, "XDrum Semi 20\" Studio Batteria Midnight Black (nera)", 385.30, MusicDeviceCategories.Acoustic,"https://m.media-amazon.com/images/I/71XexDQnzkL._AC_SL1500_.jpg","Fusti in legno di pioppo acustico di alta qualità in configurazione Studio\n" +
                    "Hardware a doppio rinforzo: supporto rullante, pedale grancassa, supporto hi-hat, supporto per piatti boom e sedile\n" +
                    "1 paio di bacchette, istruzioni di montaggio dettagliate\n" +
                    "Dimensioni del fusti: 20\" BD, 10\", 12\", 14\" TT, 14\" SD\n" +
                    "1 set di piatti charleston, 1 piatto ride/crash"));
            musicDeviceService.save(new MusicDevice(10L, "Sassofono contralto Mib Ottone Laccato Oro", 641.10, MusicDeviceCategories.Acoustic,"https://m.media-amazon.com/images/I/71Vo+2jyFbL._AC_SL1500_.jpg", "Corpo laccato oro con mi bemolle e   chiave 82Z .\n" +
                    "Sassofono contralto in mib con un suono eccezionale.\n" +
                    "Foro di risonanza accurato, costruzione robusta, cuscinetti in pelle di alta qualità con amplificatori di tono metallico.\n" +
                    "Il motivo inciso rende il sax più speciale e delicato.\n" +
                    "Spazzola per la pulizia, panno per la pulizia, guanti, tracolla e custodia imbottita sono inclusi per soddisfare meglio le tue esigenze."));
            musicDeviceService.save(new MusicDevice(11L, "Novation Launchpad Pro", 348.00, MusicDeviceCategories.MIDIProduction,"https://m.media-amazon.com/images/I/81W2-6gvkqL._AC_SL1500_.jpg", "Migliora la tua performance dal vivo con controllo manuale di clip e brani usando quattro modalità semplice\n" +
                    "Plug and Play direttamente alla Logic Pro è come una tastiera, o collegare la porta midi alla Bass Station II e giocare riffs sul vostro griglia\n" +
                    "I cuscinetti di 8 x 8 griglia di RGB illumina per abbinare il colore del vostro clips in Ableton, in modo da poter concentrarsi su trigger e combinando le asole e idee\n" +
                    "Make Dynamic Beats, giocare come uno strumento e messa a fuoco Mix senza perdere\n" +
                    "Controllo alcun effetto o strumento mid-performance per aggiungere effetti espressivi come il riverbero o filtri"));
            musicDeviceService.save(new MusicDevice(12L, "Pioneer DJ, DDJ-200, Smart Controller per DJ", 150.23, MusicDeviceCategories.MIDIProduction,"https://m.media-amazon.com/images/I/81Bhc9updaL._AC_SL1500_.jpg", "App compatibili. Collega lo smartphone, tablet o PC/Mac per iniziare a mixare. Tutta una serie di programmi software e app – tra cui WeDJ per iPhone, WeDJ per Android, djay, edjing Mix e rekordbox – sono compatibili con dispositivi selezionati. Inoltre, potrai utilizzare gratuitamente tutte le funzioni di WeDJ per iPhone per cui normalmente servono pagamenti in-app.F\n" +
                    "Siti di streaming compatibili. A seconda della combinazione di app e dispositivo, potrai mixare i suoni tramite servizi di streaming tra cui Beatport LINK, SoundCloud Go+, Deezer, TIDAL, persino Beatsource LINK. WeDJ per Android non è compatibile con i servizi di streaming.\n" +
                    "Tutorial e Pop-Hint. La nostra app aggiornata WeDJ per iPhone comprende le funzioni Tutorial e Pop-Hint. Con esse, imparerai a utilizzare la console e scoprire le basi del DJing, compresa la terminologia comune, per iniziare a mixare in men che non si dica.\n" +
                    "Transition FX. Sei solo agli inizi ai deck? Opera transizioni professionali tra i brani con la funzione Transition FX di WeDJ per iPhone. Scegli tra 11 stili di effetti e fai semplicemente scorrere il crossfader dall'altra parte per un passaggio scorrevole tra le melodie.\n" +
                    "Corpo leggero compatto. Il DDJ-200 è leggero e portatile. Lascia a casa i diffusori e riproduci i suoni dalle uscite audio del PC/Mac, smartphone o tablet. Non c'è un'uscita comoda? Nessun problema! Alimenta la console con una batteria esterna.\n" +
                    "Passa naturalmente da un brano all'altro. La funzione Phrase Sync analizzerà e allineerà le posizioni dei 2 brani e, quindi, il suono sarà naturale passando da una melodia all'altra.\n" +
                    "Uscita doppia (split). Mentre tutti gli altri ascoltano il suono master attraverso i diffusori, tu potrai ascoltare ed eseguire il cueing del brano successivo con le cuffie. Per separare l'audio ti basterà collegare i doppi cavi (split). Nota: il DDJ-200 non ha un jack per le cuffie, per collegare le cuffie è necessario collegarsi al dispositivo (smartphone/laptop) utilizzando il cavo splitter o il cavo USB nella confezione\n" +
                    "Funzioni Performance. Attiva le funzioni Performance di rekordbox semplicemente collegando l'unità al PC/Mac. Inoltre, abbonandoti al piano Creative, potrai utilizzare Cloud Library Sync per gestire le librerie senza soluzione di continuità su più dispositivi e creare facilmente versioni personalizzate dei brani in Edit mode."));
            musicDeviceService.save(new MusicDevice(13L, "AKAI Professional MPK Mini MK3 Black", 95.60, MusicDeviceCategories.MIDIProduction,"https://m.media-amazon.com/images/I/71BmRNeC9mL._AC_SL1500_.jpg", "Controller MIDI alimentato via USB con 25 mini tasti MIDI sensibili alla velocity per la produzione musicale, controllo dei synth virtuali e la produzione di beat\n" +
                    "Controllo totale della tua produzione - joystick a 4 vie per il controllo dinamico di pitch e modulazione, più un arpeggiatore interno con parametri di risoluzione, range e modalità regolabili\n" +
                    "8 pad beat MIDI retroilluminati in stile MPC sensibili alla velocity con Note Repeat e Full Level per programmare percussioni elettroniche, trigger di campioni e il controllo di DAW / synth virtuali\n" +
                    "Comando completo dei tuoi strumenti ed effetti virtuali - 8 manopole a 360° per l'assegnazione dei tuoi plug-in di studio per il mixaggio, il controllo dei parametri dei synth e molto altro ancora\n" +
                    "Oltre 1500 suoni e tutto ciò che ti serve per la produzione musicale - Starter kit completo per la produzione musicale che include MPC Beats, 6 strumenti virtuali e 2 GB di campioni"));
            musicDeviceService.save(new MusicDevice(14L, "PreSonus Eris E5, Monitor da Studio Attivo", 122.00, MusicDeviceCategories.MIDIProduction,"https://m.media-amazon.com/images/I/81lhxZr-K9S._AC_SL1500_.jpg", "Trasduttore a bassa frequenza in tessuto composito da 5,25 pollici\n" +
                    "Trasduttore da 1 pollice (25 mm), massa ultra ridotta, cupola in seta, ad alta frequenza\n" +
                    "80 watt, biamplificazione in classe AB\n" +
                    "Midrange (± 6 dB, a variazione continua), HF (± 6 dB, a variazione continua), filtro passa-alto (Off, 80 Hz, 100 Hz) e impostazioni dello spazio acustico (piatto, -2, -4 dB) per un contorno di missaggio accurato\n" +
                    "Include il software Studio One Prime (registra, produci e mixa facilmente musica e audio, tutto da un'unica applicazione intuitiva) e Studio Magic Plug-In Suite (valore di $ 1000+ di strumenti software aggiuntivi, effetti e altro). Basta registrare qualsiasi nuovo monitor da studio PreSonus sul tuo account My.PreSonus\n" +
                    "Balanced XLR 1/4-inch and unbalanced RCA inputs\n" +
                    "SPL continuo massimo di 102 dB"));
            musicDeviceService.save(new MusicDevice(15L, "Pioneer DJ DDJ-FLX6 - Controller DJ ", 649.00, MusicDeviceCategories.MIDIProduction,"https://m.media-amazon.com/images/I/81R8k6OuDEL._AC_SL1500_.jpg", "Accendi Jog Cutter e sposta la rotella per applicare un effetto antigraffio dal suono professionale all'ultima Hot Cue o posizione di riproduzione utilizzata sul mazzo\n" +
                    "La piegatura del passo e i graffi sono naturali grazie alle grandi ruote da jogging con display On Jog in modo da poter tenere d'occhio la posizione della testa di gioco\n" +
                    "Diventa creativo con il tuo suono preferito e Sample Scratch per scegliere i suoni che hai assegnato al campionatore e caricarli sui mazzi\n" +
                    "Plug and play con la scheda audio integrata e supporto per le funzioni DJ Performance compatibili con rekordbox e Serato DJ Pro\n" +
                    "Il layout dei controlli sul DDJ-FLX6 è simile a quello sul nostro set CDJ + DJM standard del club, in modo da poter eseguire in modo intuitivo"));
        };
    }
}
