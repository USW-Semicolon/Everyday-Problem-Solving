#include <iostream>
#include <stack>
#include <string>

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto input = std::string();
    std::cin >> input;

    auto answer = 0;
    auto temp = 1;
    auto stack = std::stack<char>();
    for(int i = 0; i < input.size(); i++)
    {
        auto c = input[i];

        switch(c)
        {
            case '(':
                stack.push('(');
                temp *= 2;
                break;

            case '[':
                stack.push('[');
                temp *= 3;
                break;
            
            case ')':
                if(stack.empty() || stack.top() != '(')
                {
                    std::cout << 0 << '\n';
                    return 0;
                }

                if(input[i - 1] == '(')
                    answer += temp;
                
                stack.pop();
                temp /= 2;

                break;

            case ']':
                if(stack.empty() || stack.top() != '[')
                {
                    std::cout << 0 << '\n';
                    return 0;
                }

                if(input[i - 1] == '[')
                    answer += temp;
                
                stack.pop();
                temp /= 3;
                
                break;
        }
    }

    if(stack.empty())
        std::cout << answer << '\n';
    else
        std::cout << 0 << '\n';
        
    return 0;
}