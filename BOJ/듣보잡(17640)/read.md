# 문제
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과,
N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.

듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.

# 풀이
첫 듣도 못만 사람의 수를 String array로 입력을 받도록 하였고, 
이후 입력을 받을 보도 못한사람을 입력받는데 듣도 못한 사람의 array에 존재를 하는 이름만 List에 add를 하였다.
이때 탐색은 binarySearch를 구현을 하여 시간을 단축시켰다.
```java
static boolean binarySearch(String[] str, String key) {
		int pl = 0;
		int pr = str.length - 1;

		while (pl <= pr) {
			int pc = (pl + pr) / 2;

			if (str[pc].contentEquals(key)) {
				return true;
			}

			if (str[pc].compareTo(key) < 0) {
				pl = pc + 1;
			} else if (str[pc].compareTo(key) > 0) {
				pr = pc - 1;
			}
		}
		return false;
	}
```
이진탐색을 하기 위한 가정은 우선 정렬이 되어야 한다는 것이다. 따라서 Comparator를 구현하여
오름차순으로 정렬이 되도록 하였다.

```java
Arrays.sort(str1, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2) < 0 ? -1 : 1;
			}
		});
```
