### 문제
...중략...   

첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져.   
N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수인데, 자연수가 뭔지는 알지? 모르면 물어봐도 괜찮아.    
나는 언제든지 질문에 답해줄 준비가 되어있어.   

둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와.   
포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어.    
아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어. 포켓몬 이름의 최대 길이는 20, 최소 길이는 2야.   
그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와. 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고,   
숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해. 입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고,   
입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져. 그럼 화이팅!!!

출력
첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!.    
입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼. 그럼 땡큐~   



이게 오박사님이 나에게 새로 주시려고 하는 도감이야. 너무 가지고 싶다ㅠㅜ. 꼭 만점을 받아줬으면 좋겠어!! 파이팅!!!   


### 풀이
input으로 들어온 값들을 순서와 내용을 저장하고 그대로 출력할 수 있도록 해야 한다.   
두가지의 정보를 모두 담을 수 있는 Map 구조를 사용하였고, 그중에도 순서를 보장할 수 있도록 하는 `linkedHashMap`을 사용하였다.   
```
HashMap<String, Integer> map = new LinkedHashMap<>();
```
또한 key값인 String을 담을 수 있는 list를 하나더 두었다.  
map에 주어진 input들을 모두 담고,    
퀴즈에서 String을 물어보면 인덱스를 반환해야 하므로 그대로 map.get으로 출력을 할 수 있다.   

integer를 물어보면 그에 해당하는 String을 반환해야 하는데 이때는 list.get()으로 인덱스에 해당하는 String을 출력하도록 한다.   

때문에 map에 <Integer, String> 쌍이 아니라 <String, Integer>쌍으로 저장하도록 한다.

