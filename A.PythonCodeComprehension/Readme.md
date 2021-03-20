# How to run

## Clone the repo

```bash
git clone https://github.com/Ruhshan/assignment-ebi.git
```

## Navigate to Code directory
```bash
cd A.PythonCodeComprehension
```

## Build docker image
```bash
 docker build -f Dockerfile -t python-code-comprehension . 
```

## Run the answer script
```bash
 docker run -it --rm python-code-comprehension python answer.py
```