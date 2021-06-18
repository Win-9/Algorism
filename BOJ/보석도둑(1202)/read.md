# 보석도둑(1202)

세계적인 도둑 상덕이는 보석점을 털기로 결심했다.

상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.

상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.

https://www.acmicpc.net/problem/1202

# 전략

우선 높은 V의 값을 낮은용량의 가방인 C에 match를 시켜야 최고의 값을 나타낼 수 있다.
따라서 보석의 정보를 담을 수 있는 Jam class를 생성 하고, jam class를 각각 PriorityQueue에 넣을 수 있도록 하였다.
주의점은 ArrayList로 만들었다가 값의 범위가 1억이 넘기때문에 시간초과가 생길 수 있기 때문에 우선순위 큐를 사용하도록 했다.
다시 본론으로 돌아와서, Jam Class에 compareTo를 정의하여 내림차순으로 값을 정렬하도록하고, 가방의 정보인 C는 오름차순으로 정렬시켰다.

```
class Jam implements Comparable<Jam>{
	int M;
	int V;
	
	public Jam(int M,int V){
		this.M=M;
		this.V=V;
	}

	@Override
	public int compareTo(Jam o) {
		// TODO Auto-generated method stub
		return this.V>o.V?-1:1;
	}
	

}
```


