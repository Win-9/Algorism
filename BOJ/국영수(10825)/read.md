# 문제

도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다. 이때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)

입력
첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다. 
점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.


# 풀이

주어진 정렬 기준을 지키면서 평소에 하던 정렬을 수행하면 되는 문제이다.
두가지 방법이 있는데, ArrayList를 사용해서 Comparator를 구현하는 것과,
sort부터 정렬기준까지 하나하나 구현을 하는 방법이 있다.

일단은 연습을 하는 단계이니 하나하나 구현을 하는 방법으로 문제를 풀이 하였다.
```java
static boolean compare(Infomation info1, Infomation info2) {
		if (info1.korean > info2.korean) {
			return true;
		}else if (info1.korean < info2.korean) return false;

		if (info1.eng > info2.eng) {
			return false;
		}else if (info1.eng < info2.eng) return true;

		if (info1.math > info2.math) {
			return true;
		}else if (info1.math < info2.math) return false;

		if ((info1.name).compareTo(info2.name) < 0) {
			return true;
		}

		return false;

	}
```
주어진 정렬기준을 수행하는 메소드이다.

```java
class Infomation {
	String name;
	int korean;
	int math;
	int eng;

	public Infomation(String name, int korean, int eng, int math) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.korean = korean;
		this.eng = eng;
		this.math = math;
	}
}
```
주어진 정보를 담아야 할때 따로 클래스를 만들어서 정보를 담는 것을 선호하는 편이다.
