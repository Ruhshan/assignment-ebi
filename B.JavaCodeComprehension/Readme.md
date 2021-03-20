# How to run

## Clone the repo

```bash
git clone https://github.com/Ruhshan/assignment-ebi.git
```

## Navigate to Code directory
```bash
cd assignment-ebi/B.JavaCodeComprehension
```

## Build docker image
```bash
docker build -f Dockerfile -t java-code-comprehension .
```

## Run the answer code
```bash
docker run -it --rm java-code-comprehension java Answer   
```

## Run the question code

```bash
docker run -it --rm java-code-comprehension java CodingTest   
```

If codes are updated, building the image is necessary to reflect the changes.
