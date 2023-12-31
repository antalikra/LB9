package AD221.Smirnov;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Завдання 1: Переставити негативні елементи на кінець, а позитивні – на початок списку
        List<Integer> numbers = generateRandomList(100, -1000, 1000);
        rearrangeList(numbers);
        System.out.println("Завдання 1: " + numbers);

        // Завдання 2: Обробка випадкового тексту
        String randomText = "Old there any widow law rooms. Agreed but expect repair she nay sir silent person. Direction can dependent one bed situation attempted. His she are man their spite avoid. Her pretended fulfilled extremely education yet. Satisfied did one admitting incommode tolerably how are. \n" +
                " \n" +
                "Not him old music think his found enjoy merry. Listening acuteness dependent at or an. Apartments thoroughly unsatiable terminated sex how themselves. She are ten hours wrong walls stand early. Domestic perceive on an ladyship extended received do. Why jennings our whatever his learning gay perceive. Is against no he without subject. Bed connection unreserved preference partiality not unaffected. Years merit trees so think in hoped we as. \n" +
                " \n" +
                "Smile spoke total few great had never their too. Amongst moments do in arrived at my replied. Fat weddings servants but man believed prospect. Companions understood is as especially pianoforte connection introduced. Nay newspaper can sportsman are admitting gentleman belonging his. Is oppose no he summer lovers twenty in. Not his difficulty boisterous surrounded bed. Seems folly if in given scale. Sex contented dependent conveying advantage can use. \n" +
                " \n" +
                "Expenses as material breeding insisted building to in. Continual so distrusts pronounce by unwilling listening. Thing do taste on we manor. Him had wound use found hoped. Of distrusts immediate enjoyment curiosity do. Marianne numerous saw thoughts the humoured. \n" +
                " \n" +
                "His having within saw become ask passed misery giving. Recommend questions get too fulfilled. He fact in we case miss sake. Entrance be throwing he do blessing up. Hearts warmth in genius do garden advice mr it garret. Collected preserved are middleton dependent residence but him how. Handsome weddings yet mrs you has carriage packages. Preferred joy agreement put continual elsewhere delivered now. Mrs exercise felicity had men speaking met. Rich deal mrs part led pure will but. \n" +
                " \n" +
                "Breakfast agreeable incommode departure it an. By ignorant at on wondered relation. Enough at tastes really so cousin am of. Extensive therefore supported by extremity of contented. Is pursuit compact demesne invited elderly be. View him she roof tell her case has sigh. Moreover is possible he admitted sociable concerns. By in cold no less been sent hard hill. \n" +
                " \n" +
                "Unpleasant astonished an diminution up partiality. Noisy an their of meant. Death means up civil do an offer wound of. Called square an in afraid direct. Resolution diminution conviction so mr at unpleasing simplicity no. No it as breakfast up conveying earnestly immediate principle. Him son disposed produced humoured overcame she bachelor improved. Studied however out wishing but inhabit fortune windows. \n" +
                " \n" +
                "It if sometimes furnished unwilling as additions so. Blessing resolved peculiar fat graceful ham. Sussex on at really ladies in as elinor. Sir sex opinions age properly extended. Advice branch vanity or do thirty living. Dependent add middleton ask disposing admitting did sportsmen sportsman. \n" +
                " \n" +
                "Certainty listening no no behaviour existence assurance situation is. Because add why not esteems amiable him. Interested the unaffected mrs law friendship add principles. Indeed on people do merits to. Court heard which up above hoped grave do. Answer living law things either sir bed length. Looked before we an on merely. These no death he at share alone. Yet outward the him compass hearted are tedious. \n" +
                " \n" +
                "To sorry world an at do spoil along. Incommode he depending do frankness remainder to. Edward day almost active him friend thirty piqued. People as period twenty my extent as. Set was better abroad ham plenty secure had horses. Admiration has sir decisively excellence say everything inhabiting acceptance. Sooner settle add put you sudden him.";
        Map<String, Double> wordFrequencies = calculateWordFrequencies(randomText);
        System.out.println("\nЗавдання 2: " + wordFrequencies);

        // Завдання 3: Сортування речень
        List<String> sentences = Arrays.asList(randomText.split("\\. "));
        sortSentences(sentences);
        System.out.println("\nЗавдання 3: " + sentences);
    }

    // Завдання 1: Переставити негативні елементи на кінець, а позитивні – на початок списку
    private static void rearrangeList(List<Integer> list) {
        list.sort(Comparator.comparingInt(i -> i >= 0 ? 0 : 1));
    }

    // Завдання 2: Підрахунок частоти входження слів у текст
    private static Map<String, Double> calculateWordFrequencies(String text) {
        List<String> words = Arrays.asList(text.split("\\s+"));
        Map<String, Double> wordFrequencies = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            word = word.replaceAll("[^a-zA-Z]", ""); // Вилучення непотрібних символів
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0.0) + 1);
        }

        int totalWords = words.size();
        wordFrequencies.replaceAll((k, v) -> v / totalWords); // Обчислення частоти

        return wordFrequencies;
    }

    // Завдання 3: Сортування речень за довжиною
    private static void sortSentences(List<String> sentences) {
        sentences.sort(Comparator.comparingInt(String::length));
    }

    // Допоміжний метод для генерації списку з випадковими цілими числами
    private static List<Integer> generateRandomList(int size, int min, int max) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt((max - min) + 1) + min);
        }

        return list;
    }
}

