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
    auto can_ray = false;
    auto stack = std::stack<int>();
    for(const auto c : input)
    {
        if(c == '(')
        {
            stack.push(stack.size() + 1);
            
            can_ray = true;
        }
        else
        {
            stack.pop();

            if(can_ray)
                answer += stack.size();
            else
                answer++;

            can_ray = false;
        }
    }

    std::cout << answer << '\n';

    return 0;
}