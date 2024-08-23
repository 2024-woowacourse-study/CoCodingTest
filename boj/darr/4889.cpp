#include <iostream>
#include <stack>

using namespace std;

int main() {
    int number = 1;

    while(1) {
        int moveCount = 0;
        string s;
        cin>>s;
        if(s[0] == '-') break;

        stack<int> stack;
        for(int i=0; i<s.size(); i++) {
            if(stack.empty()) {
                if(s[i] == '}') moveCount++;
                stack.push(0);
                continue;
            }
            
            if(stack.top() == 0 && s[i] == '}') {
                stack.pop();
                continue;
            }

            if(stack.top() == 1 && s[i] == '}') {
                moveCount++;
                stack.pop();
                continue;
            }

            stack.push(s[i] == '{' ? 0 : 1);
        }

        while(!stack.empty()) {
            int top1 = stack.top();
            stack.pop();
            int top2 = stack.top();
            stack.pop();

            if(top1 == 0) moveCount++;
            if(top2 == 1) moveCount++;
        }

        cout<<number<<". "<<moveCount<<endl;
        number++;
    }

    return 0;
}