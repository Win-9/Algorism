# 컵홀더(2810)

십년이면 강산이 변한다.

강산이네 동네에 드디어 극장이 생겼고, 강산이는 극장에 놀러갔다. 매점에서 콜라를 산 뒤, 자리에 앉은 강산이는 큰 혼란에 빠졌다. 양쪽 컵홀더를 이미 옆 사람들이 차지했기 때문에 콜라를 꽂을 컵 홀더가 없었기 때문이다. 영화를 보는 내내 콜라를 손에 들고 있던 강산이는 극장에 다시 왔을 때는 꼭 콜라를 컵 홀더에 놓겠다는 다짐을 한 후 집에 돌아갔다.

극장의 한 줄에는 자리가 N개가 있다. 서로 인접한 좌석 사이에는 컵홀더가 하나씩 있고, 양 끝 좌석에는 컵홀더가 하나씩 더 있다. 또, 이 극장에는 커플석이 있다. 커플석 사이에는 컵홀더가 없다.

극장의 한 줄의 정보가 주어진다. 이때, 이 줄에 사람들이 모두 앉았을 때, 컵홀더에 컵을 꽂을 수 있는 최대 사람의 수를 구하는 프로그램을 작성하시오. 모든 사람은 컵을 한 개만 들고 있고, 자신의 좌석의 양 옆에 있는 컵홀더에만 컵을 꽂을 수 있다.

S는 일반 좌석, L은 커플석을 의미하며, L은 항상 두개씩 쌍으로 주어진다.

어떤 좌석의 배치가 SLLLLSSLL일때, 컵홀더를 *로 표시하면 아래와 같다.

*S*LL*LL*S*S*LL*
위의 예에서 적어도 두 명은 컵홀더를 사용할 수 없다.

https://www.acmicpc.net/problem/2810


# 전략

컵홀더가 위의 조건에 맞춰 있다는 가정하에 얼마나 많은 사람이 컵홀더에 컵을 올릴수 있는지에대한 문제이다.
우선 접근할때 주의해야 할 점은, 컵홀더의 위치를 먼저 생각한 후에 각 사람이 선택해야 할 컵홀더를 세는 방법으로 풀려했으나, 문제의 취지와 다른 방향을 접근이 되어버리기 때문에 이 방식으로
접근한면 안된다. 따라서 각 자리에 비치할수 있는 컵홀더갯수만큼의 boolean 배열은 만들고, 가장 왼쪽자리부터 컵을 올리도록 하였고, 컵을 올렸으면, true로 만드는 방법을 사용하였다.
그리고, L좌석은 커플이기때문에 visited에서 L과L사이는 존재할 수 없기때문에 이 자리는 건너뛰어야 하는점을 주의해야 한다.

```
if(visited[count_visited]==true) {
	    			count_visited+=2;
		    		visited[count_visited]=true;
		    		System.out.println("L:: Visited_index:"+count_visited);
		    		break;
	    		}
	    		visited[count_visited]=true;
	    		System.out.println("L1:: Visited_index:"+count_visited);
	    		count_visited+=2;
	    		visited[count_visited]=true;
	    		System.out.println("L2:: Visited_index:"+count_visited);
	    		break;
          
```



# 전략2

다른사람들이 푼것을 보았는데 내가 그리디라고하면 너무 복잡하게 생각하는 경햘이 있다.
우선 간단히 접근하여, 컵홀더를 모두 세고, N보다 크면 result=N으로 해서 바로 출력해버리면 된다....


```
		int answer = 0;
		for (int i = 0; i < seats.length(); i++) {
			answer++;
			if(seats.charAt(i) == 'L') i++;
		}
		answer++;
		System.out.println(answer > n ? n : answer);
		```
