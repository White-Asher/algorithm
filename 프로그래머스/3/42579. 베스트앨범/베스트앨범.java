import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르와 재생횟수
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 플레이 순으로 장르 정렬
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        // 결과 리스트
        List<Song> playList = new ArrayList<>();
        
        for( int i = 0; i < keys.size(); i++) {
            // 노래 리스트
            List<Song> songList = new ArrayList<>();
            String tarGen = keys.get(i);
            for (int j = 0; j < genres.length; j++) {
                if (tarGen.equals(genres[j])) {
                    songList.add(new Song(genres[j], j, plays[j]));
                }
            }
            Collections.sort(songList, (o1, o2) -> o2.playCnt - o1.playCnt);
            playList.add(songList.get(0));
            if(songList.size() >= 2) {
                playList.add(songList.get(1));
            }
        }
        
        int[] answer = new int[playList.size()];
        int cnt = 0;
        for (Song s : playList) {
            answer[cnt++] = s.idx;
        }
        
        return answer;
    }
}

class Song {
    String genre;
    int idx;
    int playCnt;
    
    public Song(String genre, int idx, int playCnt) { 
        this.genre = genre;
        this.idx = idx;
        this.playCnt = playCnt;
    }
    
}