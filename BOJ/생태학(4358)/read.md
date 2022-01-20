# 문제
생태학에서 나무의 분포도를 측정하는 것은 중요하다.
그러므로 당신은 미국 전역의 나무들이 주어졌을 때, 각 종이 전체에서 몇 %를 차지하는지 구하는 프로그램을 만들어야 한다.

입력
프로그램은 여러 줄로 이루어져 있으며, 한 줄에 하나의 나무 종 이름이 주어진다. 
어떤 종 이름도 30글자를 넘지 않으며, 입력에는 최대 10,000개의 종이 주어지고 최대 1,000,000그루의 나무가 주어진다.

출력
주어진 각 종의 이름을 사전순으로 출력하고, 그 종이 차지하는 비율을 백분율로 소수점 4째자리까지 반올림해 함께 출력한다.


# 풀이

로직은 다 맞다고 판단했는데 마지막 출력에 오류가 있어서 3시간동안 계속 고민을 했다,,,
우선 로직부터 생각하면
이미 존재하는 String이면 HashTable의 value에 1을 더하고 다시 put을 하고,
존재하지 않는 Key이면 value를 1로 put한다.

```java
while (true) {
			str = br.readLine();
			if (str == null ||str.length() == 0) {
				break;
			}
			size++;
			if (hash.containsKey(str)) {
				int num = hash.get(str);
				hash.put(str, ++num);
				continue;
			}
			hash.put(str, 1);
		}
```
이후 사전순으로 출력을 해야되는데 HashTable은 정렬이 안되니까
HashTable의 KeySet을 ArrayList로 만들고 이를 출력하도록 한다.
이때 전체 size를 나누어서 퍼센트를 출력하도록 한다.
```java
for (String s : list) {
			sb.append(s+" ").append(String.format("%.4f", 
					(double) hash.get(s) * 100 / size)).append("\n");
		}
```
StringBuilder를 사용할때 append를 여러개 이용해서 문자를붙히도록 하자.
길게 한번에 넣으려고 해서 오류가 난듯 하다.
