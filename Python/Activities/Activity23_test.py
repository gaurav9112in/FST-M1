import pytest

# Write test method ( NOTE: fixture method num_list is defined inside conftest.py)
def test_sum(num_list):

    # Initialize sum
    sum = 0

    # Add number in the list
    for n in num_list:
        sum += n

    # Assertion
    assert sum == 55