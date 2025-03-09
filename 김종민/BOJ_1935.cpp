#include <iostream>
#include <string>
#include <stack>
#include <vector>

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto operand_count = 0;
    std::cin >> operand_count;

    auto expression = std::string();
    std::cin >> expression;

    auto each_values = std::vector<int>(operand_count);
    for(int i = 0; i < operand_count; i++)
        std::cin >> each_values[i];
    
    auto stack = std::stack<double>();
    for(const auto c : expression)
    {
        if('A' <= c && c <= 'Z')
        {
            stack.push(each_values[c - 'A']);
        }
        else
        {
            auto second = stack.top();
            stack.pop();

            auto first = stack.top();
            stack.pop();

            auto temp_value = 0.0;
            switch(c)
            {
                case '+':
                    temp_value = first + second;
                    break;
                
                case '-':
                    temp_value = first - second;
                    break;
                
                case '*':
                    temp_value = first * second;
                    break;
                
                case '/':
                    temp_value = first / second;
                    break;
            }

            stack.push(temp_value);
        }
    }
    printf("%.2lf\n", stack.top());

    return 0;
}