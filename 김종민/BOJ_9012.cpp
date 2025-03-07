#include <iostream>
#include <stack>
#include <queue>
#include <string>

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto loop_count = 0;
    std::cin >> loop_count;

    auto input = std::string();
    auto queue = std::queue<std::string>();

    for(int i = 0; i < loop_count; i++)
    {
        auto stack = std::stack<char>();
        auto flag = false;

        std::cin >> input;
        for(const auto c : input)
        {
            if(c == '(')
            {
                stack.push('(');
            }
            else
            {
                if(stack.empty())
                {
                    flag = true;
                    break;
                }
                stack.pop();
            }
        }

        if(!stack.empty() || flag)
        {
            queue.push("NO");
        }
        else
        {
            queue.push("YES");
        }
    }

    while(!queue.empty())
    {
        std::cout << queue.front() << '\n';
        queue.pop();
    }

    return 0;
}