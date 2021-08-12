# https://www.acmicpc.net/problem/1918

# 수식은 일반적으로 3가지 표기법으로 표현할 수 있다. 
# 연산자가 피연산자 가운데 위치하는 중위 표기법(일반적으로 우리가 쓰는 방법이다), 연산자가 피연산자 앞에 위치하는 전위 표기법(prefix notation), 연산자가 피연산자 뒤에 위치하는 후위 표기법(postfix notation)이 그것이다. 
# 예를 들어 중위 표기법으로 표현된 a+b는 전위 표기법으로는 +ab이고, 후위 표기법으로는 ab+가 된다.
# 이 문제에서 우리가 다룰 표기법은 후위 표기법이다. 
# 후위 표기법은 위에서 말한 법과 같이 연산자가 피연산자 뒤에 위치하는 방법이다. 
# 이 방법의 장점은 다음과 같다. 
# 우리가 흔히 쓰는 중위 표기식 같은 경우에는 덧셈과 곱셈의 우선순위에 차이가 있어 왼쪽부터 차례로 계산할 수 없지만 후위 표기식을 사용하면 순서를 적절히 조절하여 순서를 정해줄 수 있다. 
# 또한 같은 방법으로 괄호 등도 필요 없게 된다. 
# 예를 들어 a+b*c를 후위 표기식으로 바꾸면 abc*+가 된다.
# 중위 표기식을 후위 표기식으로 바꾸는 방법을 간단히 설명하면 이렇다. 
# 우선 주어진 중위 표기식을 연산자의 우선순위에 따라 괄호로 묶어준다. 
# 그런 다음에 괄호 안의 연산자를 괄호의 오른쪽으로 옮겨주면 된다.
# 예를 들어 a+b*c는 (a+(b*c))의 식과 같게 된다. 
# 그 다음에 안에 있는 괄호의 연산자 *를 괄호 밖으로 꺼내게 되면 (a+bc*)가 된다. 
# 마지막으로 또 +를 괄호의 오른쪽으로 고치면 abc*+가 되게 된다.
# 다른 예를 들어 그림으로 표현하면 A+B*C-D/E를 완전하게 괄호로 묶고 연산자를 이동시킬 장소를 표시하면 다음과 같이 된다.
# 이러한 사실을 알고 중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램을 작성하시오


# 피연산자는 바로 출력
# 연산자가 들어오면 자기보다 우선순위가 높거나 같은 것을 빼고 자신을 스택에 담음
# 여는 괄호를 만나면 무조건 스택에 담음
# 닫는 괄호를 만나면 여는 괄호를 다시 만날때까지 스택에서 출력


# 피연산자(문제에서는 알파벳이 피연산자)인지 확인하기
# 토큰 분류하기 
# (면 무조건 스택에 넣음
# )면 스택이 비거나 스택에서 여는 괄호를 만날때까지 스택에서 빼냄

# A*(B+C)

# stack=[], res = ''
# A *(B+C) => stack=[], res='A'
# * (B+C) => stack=['*'], res='A'
# ( B+C) => stack=['*', '('], res='A'
# B +C) => stack=['*', '('], res='AB'
# + C) => stack=['*', '('], res='AB'
# C ) => stack=['*', '(', '+'], res='ABC'
# ) => stack=['*'], res='ABC+'
# => stack=[], res='ABC+*'


# (A+B)*(C-D)

# stack=[], res = ''
# ( A+B)*(C-D) => stack=['('], res = ''
# A +B)*(C-D) => stack=['('], res = 'A'
# + B)*(C-D) => stack=['(', '+'], res = 'A'
# B )*(C-D) => stack=['(', '+'], res = 'AB'
# ) *(C-D) => stack=[], res = 'AB+'
# * (C-D) => stack=['*'], res = 'AB+'
# ( C-D) => stack=['*', '('], res = 'AB+'
# C -D) => stack=['*', '('], res = 'AB+C'
# - D) => stack=['*', '(', '-'], res = 'AB+C'
# D ) => stack=['*', '(', '-'], res = 'AB+CD'
# ) => stack=['*'], res = 'AB+CD-'
# => stack=[], res = 'AB+CD-*'


# (A*B)+C
# stack=[], res = ''
# ( A*B)+C => stack=['('], res = ''
# A *B)+C => stack=['('], res = 'A'
# * B)+C => stack=['(', '*'], res = 'A'
# B )+C => stack=['(', '*'], res = 'AB'
# ) +C => stack=[], res = 'AB*'
# + C => stack=['+'], res = 'AB*'
# C => stack=['+'], res = 'AB*C'
# => stack=['+'], res = 'AB*C+'

# A*B+C
# stack=[], res = ''
# A *B+C => stack=[], res = 'A'
# * B+C => stack=['*'], res = 'A'
# B +C => stack=['*'], res = 'AB'
# + C => stack=['+'], res = 'AB*'
# C => stack=['+'], res = 'AB*C'
# => stack=[], res = 'AB*C+'