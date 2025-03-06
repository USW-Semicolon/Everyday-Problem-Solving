#include <iostream>
#include <stack>
#include <queue>
#include <string>

auto stack = std::stack<int>();
auto answer = std::queue<int>();

void Push(int);
void Pop();
void Size();
void Empty();
void Top();

int main(int argc, char* argv[])
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);

    auto loop_count = 0;
    std::cin >> loop_count;

    auto command = std::string();
    for(int i = 0; i < loop_count; i++)
    {
        std::cin >> command;

        if(command == "push")
        {
            auto arg = 0;
            std::cin >> arg;

            Push(arg);
        }
        else if(command == "pop")
        {
            Pop();
        }
        else if(command == "size")
        {
            Size();
        }
        else if(command == "empty")
        {
            Empty();
        }
        else if(command == "top")
        {
            Top();
        }
    }

    while(!answer.empty())
    {
        std::cout << answer.front() << '\n';
        answer.pop();
    }

    return 0;
}

void Push(int target)
{
    stack.push(target);
}

void Pop()
{
    if(stack.empty())
    {
        answer.push(-1);
        return;
    }
    
    answer.push(stack.top());
    stack.pop();
}

void Size()
{
    answer.push(stack.size());
}

void Empty()
{
    if(stack.empty())
    {
        answer.push(1);
    }
    else
    {
        answer.push(0);
    }
}

void Top()
{
    if(stack.empty())
    {
        answer.push(-1);
        return;
    }

    answer.push(stack.top());
}