#include <iostream>
#include <stack>
#include <vector>
#include <queue>

auto queue = std::queue<char>();
auto stack = std::stack<int>();

void Push(int arg)
{
    stack.push(arg);
    queue.push('+');
}

void Pop()
{
    stack.pop();
    queue.push('-');
}

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto max = 0;
    std::cin >> max;

    auto target = std::vector<int>(max);
    for(int i = 0; i < max; i++)
        std::cin >> target[i];
    
    auto current = 1;
    auto index = 0;
    while(index < max)
    {
        if(current <= target[index])
        {
            while(current <= target[index])
            {
                Push(current);
                current++;
            }
        }

        if(!stack.empty() && stack.top() == target[index])
        {
            Pop();
            index++;
        }
        else
        {
            std::cout << "NO" << '\n';
            return 0;
        }
    }

    while(!queue.empty())
    {
        std::cout << queue.front() << '\n';
        queue.pop();
    }

    return 0;
}