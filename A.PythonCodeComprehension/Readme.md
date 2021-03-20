# How to run

## Clone the repo

```bash
git clone https://github.com/Ruhshan/assignment-ebi.git
```

## Navigate to Code directory
```bash
cd assignment-ebi/A.PythonCodeComprehension
```

## Build docker image
```bash
 docker build -f Dockerfile -t python-code-comprehension . 
```

## Run the answer script
```bash
 docker run -it --rm python-code-comprehension python answer.py
```

## Run the question script

```bash
 docker run -it --rm python-code-comprehension python question.py
```

If scripts are updated,, building the image is necessary to reflect the changes.
